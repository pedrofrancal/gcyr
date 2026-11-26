package argent_matter.gcyr.common.data.entity;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.api.space.planet.Planet;
import argent_matter.gcyr.data.loader.PlanetData;
import argent_matter.gcyr.util.PosWithState;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GCYREntityDataSerializers {

    private static final DeferredRegister<EntityDataSerializer<?>> SERIALIZERS = DeferredRegister
            .create(NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, GCYR.MOD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, PosWithState> POS_WITH_STATE_CODEC = StreamCodec
            .composite(
                    BlockPos.STREAM_CODEC, PosWithState::pos,
                    ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), PosWithState::state,
                    ByteBufCodecs.optional(ByteBufCodecs.COMPOUND_TAG),
                    p -> Optional.ofNullable(p.entityTag()),
                    (pos, state, tag) -> new PosWithState(pos, state, tag.orElse(null)));

    public static final EntityDataSerializer<Long> LONG = EntityDataSerializer.forValueType(ByteBufCodecs.VAR_LONG);

    public static final EntityDataSerializer<List<BlockPos>> BLOCK_POS_LIST = new EntityDataSerializer<>() {

        private static final StreamCodec<RegistryFriendlyByteBuf, List<BlockPos>> CODEC = BlockPos.STREAM_CODEC
                .apply(ByteBufCodecs.list()).cast();

        @Override
        public StreamCodec<? super RegistryFriendlyByteBuf, List<BlockPos>> codec() {
            return CODEC;
        }

        @Override
        public List<BlockPos> copy(List<BlockPos> value) {
            return new ArrayList<>(value);
        }
    };

    public static final EntityDataSerializer<PosWithState> POSITIONED_BLOCK_STATE = new EntityDataSerializer<>() {

        @Override
        public StreamCodec<? super RegistryFriendlyByteBuf, PosWithState> codec() {
            return POS_WITH_STATE_CODEC;
        }

        @Override
        public PosWithState copy(PosWithState value) {
            return new PosWithState(value.pos(), value.state(),
                    value.entityTag() == null ? null : value.entityTag().copy());
        }
    };

    public static final EntityDataSerializer<List<PosWithState>> POSITIONED_BLOCK_STATE_LIST = new EntityDataSerializer<>() {

        private static final StreamCodec<RegistryFriendlyByteBuf, List<PosWithState>> CODEC = POS_WITH_STATE_CODEC
                .apply(ByteBufCodecs.list());

        @Override
        public StreamCodec<? super RegistryFriendlyByteBuf, List<PosWithState>> codec() {
            return CODEC;
        }

        @Override
        public List<PosWithState> copy(List<PosWithState> value) {
            return new ArrayList<>(value);
        }
    };

    public static final EntityDataSerializer<Optional<Planet>> PLANET = EntityDataSerializer.forValueType(
            ByteBufCodecs.optional(ResourceLocation.STREAM_CODEC.map(PlanetData::getPlanet, PlanetData::getPlanetId)));

    public static void register(IEventBus modBus) {
        SERIALIZERS.register("long", () -> LONG);
        SERIALIZERS.register("block_pos_list", () -> BLOCK_POS_LIST);
        SERIALIZERS.register("positioned_block_state", () -> POSITIONED_BLOCK_STATE);
        SERIALIZERS.register("positioned_block_state_list", () -> POSITIONED_BLOCK_STATE_LIST);
        SERIALIZERS.register("planet", () -> PLANET);
        SERIALIZERS.register(modBus);
    }
}
