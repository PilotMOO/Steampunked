package mod.pilot.steampunked.entity.client;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ReconZombie<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Reconstructed;
	private final ModelPart Base;
	private final ModelPart TorsoBase;
	private final ModelPart TorsoBaseCuboids;
	private final ModelPart Grate;
	private final ModelPart TorsoTop;
	private final ModelPart TCoreSolo;
	private final ModelPart Arms;
	private final ModelPart RightArm;
	private final ModelPart RightArmSeg2;
	private final ModelPart RightArmSeg2Solo;
	private final ModelPart RightArmSeg1Gears;
	private final ModelPart LargeGear2;
	private final ModelPart LGear1Spoke2;
	private final ModelPart LGear1Wheel2;
	private final ModelPart LGear1Connection5;
	private final ModelPart LGear1Connection6;
	private final ModelPart LGear1Connection7;
	private final ModelPart LGear1Connection8;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmSeg2;
	private final ModelPart LeftArmSeg2Solo;
	private final ModelPart LeftArmVent3;
	private final ModelPart LeftArmVent;
	private final ModelPart LeftArmVent2;
	private final ModelPart NeckCorething;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart HeadGears;
	private final ModelPart LargeGear;
	private final ModelPart LGear1Spoke;
	private final ModelPart LGear1Wheel;
	private final ModelPart LGear1Connection1;
	private final ModelPart LGear1Connection2;
	private final ModelPart LGear1Connection3;
	private final ModelPart LGear1Connection4;
	private final ModelPart SmallGear2;
	private final ModelPart SGear1Spoke2;
	private final ModelPart SGear1Wheel2;
	private final ModelPart SGear1Connection5;
	private final ModelPart SGear1Connection6;
	private final ModelPart SGear1Connection7;
	private final ModelPart SGear1Connection8;
	private final ModelPart MediumGear2;
	private final ModelPart MGear1Spoke2;
	private final ModelPart MGear1Wheel2;
	private final ModelPart MGear1Connection5;
	private final ModelPart MGear1Connection6;
	private final ModelPart MGear1Connection7;
	private final ModelPart MGear1Connection8;
	private final ModelPart TorsoTopGears;
	private final ModelPart MediumGear;
	private final ModelPart MGear1Spoke;
	private final ModelPart MGear1Wheel;
	private final ModelPart MGear1Connection1;
	private final ModelPart MGear1Connection2;
	private final ModelPart MGear1Connection3;
	private final ModelPart MGear1Connection4;
	private final ModelPart SmallGear;
	private final ModelPart SGear1Spoke;
	private final ModelPart SGear1Wheel;
	private final ModelPart SGear1Connection1;
	private final ModelPart SGear1Connection2;
	private final ModelPart SGear1Connection3;
	private final ModelPart SGear1Connection4;
	private final ModelPart Legs;
	private final ModelPart RLeg;
	private final ModelPart RLSeg2;
	private final ModelPart RLSeg2Solo;
	private final ModelPart RightLegSeg1Gears;
	private final ModelPart MediumGear3;
	private final ModelPart MGear1Spoke3;
	private final ModelPart MGear1Wheel3;
	private final ModelPart MGear1Connection9;
	private final ModelPart MGear1Connection10;
	private final ModelPart MGear1Connection11;
	private final ModelPart MGear1Connection12;
	private final ModelPart LLeg;
	private final ModelPart LLSeg2;
	private final ModelPart LLSeg2Solo;

	public ReconZombie(ModelPart root) {
		this.Reconstructed = root.getChild("Reconstructed");
		this.Base = Reconstructed.getChild("Base");
		this.TorsoBase = Base.getChild("TorsoBase");
		this.TorsoBaseCuboids = TorsoBase.getChild("TorsoBaseCuboids");
		this.Grate = TorsoBaseCuboids.getChild("Grate");
		this.TorsoTop = TorsoBase.getChild("TorsoTop");
		this.TCoreSolo = TorsoTop.getChild("TCoreSolo");
		this.Arms = TorsoTop.getChild("Arms");
		this.RightArm = Arms.getChild("RightArm");
		this.RightArmSeg2 = RightArm.getChild("RightArmSeg2");
		this.RightArmSeg2Solo = RightArmSeg2.getChild("RightArmSeg2Solo");
		this.RightArmSeg1Gears = RightArm.getChild("RightArmSeg1Gears");
		this.LargeGear2 = RightArmSeg1Gears.getChild("LargeGear2");
		this.LGear1Spoke2 = LargeGear2.getChild("LGear1Spoke2");
		this.LGear1Wheel2 = LargeGear2.getChild("LGear1Wheel2");
		this.LGear1Connection5 = LGear1Wheel2.getChild("LGear1Connection5");
		this.LGear1Connection6 = LGear1Wheel2.getChild("LGear1Connection6");
		this.LGear1Connection7 = LGear1Wheel2.getChild("LGear1Connection7");
		this.LGear1Connection8 = LGear1Wheel2.getChild("LGear1Connection8");
		this.LeftArm = Arms.getChild("LeftArm");
		this.LeftArmSeg2 = LeftArm.getChild("LeftArmSeg2");
		this.LeftArmSeg2Solo = LeftArmSeg2.getChild("LeftArmSeg2Solo");
		this.LeftArmVent3 = LeftArmSeg2Solo.getChild("LeftArmVent3");
		this.LeftArmVent = LeftArm.getChild("LeftArmVent");
		this.LeftArmVent2 = LeftArm.getChild("LeftArmVent2");
		this.NeckCorething = TorsoTop.getChild("NeckCorething");
		this.Head = NeckCorething.getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.HeadGears = Head.getChild("HeadGears");
		this.LargeGear = HeadGears.getChild("LargeGear");
		this.LGear1Spoke = LargeGear.getChild("LGear1Spoke");
		this.LGear1Wheel = LargeGear.getChild("LGear1Wheel");
		this.LGear1Connection1 = LGear1Wheel.getChild("LGear1Connection1");
		this.LGear1Connection2 = LGear1Wheel.getChild("LGear1Connection2");
		this.LGear1Connection3 = LGear1Wheel.getChild("LGear1Connection3");
		this.LGear1Connection4 = LGear1Wheel.getChild("LGear1Connection4");
		this.SmallGear2 = HeadGears.getChild("SmallGear2");
		this.SGear1Spoke2 = SmallGear2.getChild("SGear1Spoke2");
		this.SGear1Wheel2 = SmallGear2.getChild("SGear1Wheel2");
		this.SGear1Connection5 = SGear1Wheel2.getChild("SGear1Connection5");
		this.SGear1Connection6 = SGear1Wheel2.getChild("SGear1Connection6");
		this.SGear1Connection7 = SGear1Wheel2.getChild("SGear1Connection7");
		this.SGear1Connection8 = SGear1Wheel2.getChild("SGear1Connection8");
		this.MediumGear2 = HeadGears.getChild("MediumGear2");
		this.MGear1Spoke2 = MediumGear2.getChild("MGear1Spoke2");
		this.MGear1Wheel2 = MediumGear2.getChild("MGear1Wheel2");
		this.MGear1Connection5 = MGear1Wheel2.getChild("MGear1Connection5");
		this.MGear1Connection6 = MGear1Wheel2.getChild("MGear1Connection6");
		this.MGear1Connection7 = MGear1Wheel2.getChild("MGear1Connection7");
		this.MGear1Connection8 = MGear1Wheel2.getChild("MGear1Connection8");
		this.TorsoTopGears = TorsoTop.getChild("TorsoTopGears");
		this.MediumGear = TorsoTopGears.getChild("MediumGear");
		this.MGear1Spoke = MediumGear.getChild("MGear1Spoke");
		this.MGear1Wheel = MediumGear.getChild("MGear1Wheel");
		this.MGear1Connection1 = MGear1Wheel.getChild("MGear1Connection1");
		this.MGear1Connection2 = MGear1Wheel.getChild("MGear1Connection2");
		this.MGear1Connection3 = MGear1Wheel.getChild("MGear1Connection3");
		this.MGear1Connection4 = MGear1Wheel.getChild("MGear1Connection4");
		this.SmallGear = TorsoTopGears.getChild("SmallGear");
		this.SGear1Spoke = SmallGear.getChild("SGear1Spoke");
		this.SGear1Wheel = SmallGear.getChild("SGear1Wheel");
		this.SGear1Connection1 = SGear1Wheel.getChild("SGear1Connection1");
		this.SGear1Connection2 = SGear1Wheel.getChild("SGear1Connection2");
		this.SGear1Connection3 = SGear1Wheel.getChild("SGear1Connection3");
		this.SGear1Connection4 = SGear1Wheel.getChild("SGear1Connection4");
		this.Legs = Base.getChild("Legs");
		this.RLeg = Legs.getChild("RLeg");
		this.RLSeg2 = RLeg.getChild("RLSeg2");
		this.RLSeg2Solo = RLSeg2.getChild("RLSeg2Solo");
		this.RightLegSeg1Gears = RLeg.getChild("RightLegSeg1Gears");
		this.MediumGear3 = RightLegSeg1Gears.getChild("MediumGear3");
		this.MGear1Spoke3 = MediumGear3.getChild("MGear1Spoke3");
		this.MGear1Wheel3 = MediumGear3.getChild("MGear1Wheel3");
		this.MGear1Connection9 = MGear1Wheel3.getChild("MGear1Connection9");
		this.MGear1Connection10 = MGear1Wheel3.getChild("MGear1Connection10");
		this.MGear1Connection11 = MGear1Wheel3.getChild("MGear1Connection11");
		this.MGear1Connection12 = MGear1Wheel3.getChild("MGear1Connection12");
		this.LLeg = Legs.getChild("LLeg");
		this.LLSeg2 = LLeg.getChild("LLSeg2");
		this.LLSeg2Solo = LLSeg2.getChild("LLSeg2Solo");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Reconstructed = partdefinition.addOrReplaceChild("Reconstructed", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Base = Reconstructed.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TorsoBase = Base.addOrReplaceChild("TorsoBase", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition TorsoBaseCuboids = TorsoBase.addOrReplaceChild("TorsoBaseCuboids", CubeListBuilder.create().texOffs(52, 11).addBox(-4.0F, -18.0F, -18.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 36).addBox(-4.0F, -13.0F, -17.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 32).addBox(-4.0F, -18.0F, -17.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(3.0F, -17.0F, -17.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 53).addBox(-4.0F, -17.0F, -17.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 16.0F));

		PartDefinition Grate = TorsoBaseCuboids.addOrReplaceChild("Grate", CubeListBuilder.create().texOffs(0, 30).addBox(-5.0F, -5.5F, -1.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(-0.95F)), PartPose.offset(0.01F, -12.5F, -14.0F));

		PartDefinition TorsoTop = TorsoBase.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(28, 11).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition TCoreSolo = TorsoTop.addOrReplaceChild("TCoreSolo", CubeListBuilder.create().texOffs(26, 56).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arms = TorsoTop.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(28, 46).addBox(-4.0F, -1.005F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 58).addBox(-3.0F, -0.995F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -5.005F, 0.0F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(14, 58).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 5.005F, 0.0F));

		PartDefinition RightArmSeg2Solo = RightArmSeg2.addOrReplaceChild("RightArmSeg2Solo", CubeListBuilder.create().texOffs(16, 40).addBox(-2.0F, -0.01F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArmSeg1Gears = RightArm.addOrReplaceChild("RightArmSeg1Gears", CubeListBuilder.create(), PartPose.offset(-3.0F, 5.005F, 0.0F));

		PartDefinition LargeGear2 = RightArmSeg1Gears.addOrReplaceChild("LargeGear2", CubeListBuilder.create().texOffs(70, 8).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(1.0F, -2.5F, 0.0F, 1.789F, 0.1222F, -0.0436F));

		PartDefinition LGear1Spoke2 = LargeGear2.addOrReplaceChild("LGear1Spoke2", CubeListBuilder.create().texOffs(40, 46).mirror().addBox(-0.5F, -1.0F, 0.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 59).mirror().addBox(0.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 26).mirror().addBox(-3.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition LGear1Wheel2 = LargeGear2.addOrReplaceChild("LGear1Wheel2", CubeListBuilder.create().texOffs(12, 39).mirror().addBox(3.5F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 39).mirror().addBox(-4.5F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(43, 32).mirror().addBox(-1.5F, -1.0F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(43, 32).mirror().addBox(-1.5F, -1.0F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 70).mirror().addBox(-0.5F, -1.0F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(59, 69).mirror().addBox(-0.5F, -1.0F, 4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(55, 69).mirror().addBox(-5.4F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(39, 69).mirror().addBox(4.4F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition LGear1Connection5 = LGear1Wheel2.addOrReplaceChild("LGear1Connection5", CubeListBuilder.create(), PartPose.offset(1.6228F, -0.5F, -3.8036F));

		PartDefinition Wheeltooth_r1 = LGear1Connection5.addOrReplaceChild("Wheeltooth_r1", CubeListBuilder.create().texOffs(69, 38).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r2 = LGear1Connection5.addOrReplaceChild("Wheeltooth_r2", CubeListBuilder.create().texOffs(40, 56).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1235F, 0.0F, 2.0989F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r1 = LGear1Connection5.addOrReplaceChild("WheelSeg_r1", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1235F, 0.0F, 2.0989F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LGear1Connection6 = LGear1Wheel2.addOrReplaceChild("LGear1Connection6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Wheeltooth_r3 = LGear1Connection6.addOrReplaceChild("Wheeltooth_r3", CubeListBuilder.create().texOffs(30, 69).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r4 = LGear1Connection6.addOrReplaceChild("Wheeltooth_r4", CubeListBuilder.create().texOffs(52, 20).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r2 = LGear1Connection6.addOrReplaceChild("WheelSeg_r2", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LGear1Connection7 = LGear1Wheel2.addOrReplaceChild("LGear1Connection7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Wheeltooth_r5 = LGear1Connection7.addOrReplaceChild("Wheeltooth_r5", CubeListBuilder.create().texOffs(69, 24).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r6 = LGear1Connection7.addOrReplaceChild("Wheeltooth_r6", CubeListBuilder.create().texOffs(48, 13).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r3 = LGear1Connection7.addOrReplaceChild("WheelSeg_r3", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LGear1Connection8 = LGear1Wheel2.addOrReplaceChild("LGear1Connection8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Wheeltooth_r7 = LGear1Connection8.addOrReplaceChild("Wheeltooth_r7", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Wheeltooth_r8 = LGear1Connection8.addOrReplaceChild("Wheeltooth_r8", CubeListBuilder.create().texOffs(13, 69).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r4 = LGear1Connection8.addOrReplaceChild("WheelSeg_r4", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(39, 36).addBox(0.0F, -1.005F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(50, 56).addBox(1.0F, -0.995F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -5.005F, 0.0F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(50, 56).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 5.005F, 0.0F));

		PartDefinition LeftArmSeg2Solo = LeftArmSeg2.addOrReplaceChild("LeftArmSeg2Solo", CubeListBuilder.create().texOffs(0, 39).addBox(-2.0F, -0.01F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArmVent3 = LeftArmSeg2Solo.addOrReplaceChild("LeftArmVent3", CubeListBuilder.create().texOffs(63, 24).mirror().addBox(0.35F, -5.75F, -0.9967F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(24, 19).mirror().addBox(1.35F, -7.25F, -0.9967F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.0F, -0.9933F, 0.1331F, 0.5092F, 0.1849F));

		PartDefinition VentSeg3_r1 = LeftArmVent3.addOrReplaceChild("VentSeg3_r1", CubeListBuilder.create().texOffs(63, 38).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.5F, -1.0F, -0.0067F, 0.0F, 0.0F, 0.6109F));

		PartDefinition LeftArmVent = LeftArm.addOrReplaceChild("LeftArmVent", CubeListBuilder.create().texOffs(6, 64).mirror().addBox(0.5F, -6.0F, -0.9967F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 49).mirror().addBox(1.5F, -8.0F, -0.9967F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 4.005F, 0.0067F, -0.0999F, -0.5148F, 0.2009F));

		PartDefinition VentSeg1_r1 = LeftArmVent.addOrReplaceChild("VentSeg1_r1", CubeListBuilder.create().texOffs(64, 18).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -1.0F, -0.0067F, 0.0F, 0.0F, 0.6109F));

		PartDefinition LeftArmVent2 = LeftArm.addOrReplaceChild("LeftArmVent2", CubeListBuilder.create().texOffs(63, 24).mirror().addBox(0.5F, -5.75F, -0.9967F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(24, 19).mirror().addBox(1.5F, -7.25F, -0.9967F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(2.5F, 4.005F, 1.0067F, -0.543F, -0.8367F, 0.6826F));

		PartDefinition VentSeg2_r1 = LeftArmVent2.addOrReplaceChild("VentSeg2_r1", CubeListBuilder.create().texOffs(63, 38).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.5F, -1.0F, -0.0067F, 0.0F, 0.0F, 0.6109F));

		PartDefinition NeckCorething = TorsoTop.addOrReplaceChild("NeckCorething", CubeListBuilder.create().texOffs(16, 50).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition Head = NeckCorething.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 15).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.1F))
		.texOffs(32, 6).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.05F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(32, 21).addBox(-4.0F, -0.5F, 0.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 26).addBox(-4.0F, -1.5F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition HeadGears = Head.addOrReplaceChild("HeadGears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LargeGear = HeadGears.addOrReplaceChild("LargeGear", CubeListBuilder.create().texOffs(70, 8).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offsetAndRotation(-1.25F, -3.5F, 1.5F, 0.2182F, 0.0F, -0.3054F));

		PartDefinition LGear1Spoke = LargeGear.addOrReplaceChild("LGear1Spoke", CubeListBuilder.create().texOffs(40, 46).mirror().addBox(-0.5F, -1.0F, 0.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(5, 59).mirror().addBox(0.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 0).mirror().addBox(-0.5F, -1.0F, -3.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(52, 26).mirror().addBox(-3.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition LGear1Wheel = LargeGear.addOrReplaceChild("LGear1Wheel", CubeListBuilder.create().texOffs(12, 39).mirror().addBox(3.5F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 39).mirror().addBox(-4.5F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(43, 32).mirror().addBox(-1.5F, -1.0F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(43, 32).mirror().addBox(-1.5F, -1.0F, 3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(7, 70).mirror().addBox(-0.5F, -1.0F, -5.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(67, 69).mirror().addBox(-0.5F, -1.0F, 4.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(55, 69).mirror().addBox(-5.4F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(39, 69).mirror().addBox(4.4F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition LGear1Connection1 = LGear1Wheel.addOrReplaceChild("LGear1Connection1", CubeListBuilder.create(), PartPose.offset(1.6228F, -0.5F, -3.8036F));

		PartDefinition Wheeltooth_r9 = LGear1Connection1.addOrReplaceChild("Wheeltooth_r9", CubeListBuilder.create().texOffs(69, 38).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r10 = LGear1Connection1.addOrReplaceChild("Wheeltooth_r10", CubeListBuilder.create().texOffs(40, 56).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1235F, 0.0F, 2.0989F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r5 = LGear1Connection1.addOrReplaceChild("WheelSeg_r5", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1235F, 0.0F, 2.0989F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LGear1Connection2 = LGear1Wheel.addOrReplaceChild("LGear1Connection2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Wheeltooth_r11 = LGear1Connection2.addOrReplaceChild("Wheeltooth_r11", CubeListBuilder.create().texOffs(30, 69).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r12 = LGear1Connection2.addOrReplaceChild("Wheeltooth_r12", CubeListBuilder.create().texOffs(52, 20).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r6 = LGear1Connection2.addOrReplaceChild("WheelSeg_r6", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LGear1Connection3 = LGear1Wheel.addOrReplaceChild("LGear1Connection3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Wheeltooth_r13 = LGear1Connection3.addOrReplaceChild("Wheeltooth_r13", CubeListBuilder.create().texOffs(69, 24).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r14 = LGear1Connection3.addOrReplaceChild("Wheeltooth_r14", CubeListBuilder.create().texOffs(48, 13).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r7 = LGear1Connection3.addOrReplaceChild("WheelSeg_r7", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LGear1Connection4 = LGear1Wheel.addOrReplaceChild("LGear1Connection4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Wheeltooth_r15 = LGear1Connection4.addOrReplaceChild("Wheeltooth_r15", CubeListBuilder.create().texOffs(0, 41).mirror().addBox(0.4F, -0.51F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(49, 0).mirror().addBox(-0.5F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Wheeltooth_r16 = LGear1Connection4.addOrReplaceChild("Wheeltooth_r16", CubeListBuilder.create().texOffs(13, 69).mirror().addBox(-0.25F, -0.51F, -1.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).mirror(false)
		.texOffs(30, 21).mirror().addBox(-0.5F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r8 = LGear1Connection4.addOrReplaceChild("WheelSeg_r8", CubeListBuilder.create().texOffs(48, 4).mirror().addBox(-0.25F, -0.5F, -1.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SmallGear2 = HeadGears.addOrReplaceChild("SmallGear2", CubeListBuilder.create().texOffs(50, 70).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -3.5F, 1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition SGear1Spoke2 = SmallGear2.addOrReplaceChild("SGear1Spoke2", CubeListBuilder.create().texOffs(25, 67).mirror().addBox(-0.5F, -1.0F, 0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(66, 67).mirror().addBox(0.25F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(58, 66).mirror().addBox(-0.5F, -1.0F, -2.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(29, 67).mirror().addBox(-2.25F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition SGear1Wheel2 = SmallGear2.addOrReplaceChild("SGear1Wheel2", CubeListBuilder.create().texOffs(66, 56).mirror().addBox(-1.0F, -1.0F, -2.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(70, 43).mirror().addBox(-0.5F, -1.0F, -3.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(40, 66).mirror().addBox(-2.75F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(70, 29).mirror().addBox(-3.2F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(40, 66).mirror().addBox(1.75F, -1.01F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(68, 50).mirror().addBox(2.2F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(20, 70).mirror().addBox(-0.5F, -1.0F, 2.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(66, 56).mirror().addBox(-1.0F, -1.0F, 1.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition SGear1Connection5 = SGear1Wheel2.addOrReplaceChild("SGear1Connection5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Wheeltooth_r17 = SGear1Connection5.addOrReplaceChild("Wheeltooth_r17", CubeListBuilder.create().texOffs(16, 70).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r18 = SGear1Connection5.addOrReplaceChild("Wheeltooth_r18", CubeListBuilder.create().texOffs(68, 48).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r9 = SGear1Connection5.addOrReplaceChild("WheelSeg_r9", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r10 = SGear1Connection5.addOrReplaceChild("WheelSeg_r10", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r11 = SGear1Connection5.addOrReplaceChild("WheelSeg_r11", CubeListBuilder.create().texOffs(32, 23).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SGear1Connection6 = SGear1Wheel2.addOrReplaceChild("SGear1Connection6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Wheeltooth_r19 = SGear1Connection6.addOrReplaceChild("Wheeltooth_r19", CubeListBuilder.create().texOffs(70, 15).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r20 = SGear1Connection6.addOrReplaceChild("Wheeltooth_r20", CubeListBuilder.create().texOffs(44, 66).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r12 = SGear1Connection6.addOrReplaceChild("WheelSeg_r12", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r13 = SGear1Connection6.addOrReplaceChild("WheelSeg_r13", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r14 = SGear1Connection6.addOrReplaceChild("WheelSeg_r14", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SGear1Connection7 = SGear1Wheel2.addOrReplaceChild("SGear1Connection7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Wheeltooth_r21 = SGear1Connection7.addOrReplaceChild("Wheeltooth_r21", CubeListBuilder.create().texOffs(70, 13).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r22 = SGear1Connection7.addOrReplaceChild("Wheeltooth_r22", CubeListBuilder.create().texOffs(62, 18).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r15 = SGear1Connection7.addOrReplaceChild("WheelSeg_r15", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r16 = SGear1Connection7.addOrReplaceChild("WheelSeg_r16", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r17 = SGear1Connection7.addOrReplaceChild("WheelSeg_r17", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SGear1Connection8 = SGear1Wheel2.addOrReplaceChild("SGear1Connection8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Wheeltooth_r23 = SGear1Connection8.addOrReplaceChild("Wheeltooth_r23", CubeListBuilder.create().texOffs(70, 11).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r24 = SGear1Connection8.addOrReplaceChild("Wheeltooth_r24", CubeListBuilder.create().texOffs(22, 60).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r18 = SGear1Connection8.addOrReplaceChild("WheelSeg_r18", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r19 = SGear1Connection8.addOrReplaceChild("WheelSeg_r19", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r20 = SGear1Connection8.addOrReplaceChild("WheelSeg_r20", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MediumGear2 = HeadGears.addOrReplaceChild("MediumGear2", CubeListBuilder.create().texOffs(34, 64).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(2.0F, -5.5F, -2.0F, 0.0F, 0.0F, 1.3526F));

		PartDefinition MGear1Spoke2 = MediumGear2.addOrReplaceChild("MGear1Spoke2", CubeListBuilder.create().texOffs(40, 64).addBox(0.25F, -1.25F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F))
		.texOffs(63, 44).addBox(-3.25F, -1.25F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F))
		.texOffs(19, 64).addBox(-0.5F, -1.25F, 0.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F))
		.texOffs(64, 0).addBox(-0.5F, -1.25F, -3.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition MGear1Wheel2 = MediumGear2.addOrReplaceChild("MGear1Wheel2", CubeListBuilder.create().texOffs(63, 52).addBox(2.95F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F))
		.texOffs(0, 69).addBox(3.6F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(63, 30).addBox(-1.5F, -1.25F, -3.95F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F))
		.texOffs(32, 6).addBox(-0.5F, -1.25F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(63, 52).addBox(-3.95F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F))
		.texOffs(68, 58).addBox(-4.6F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(63, 30).addBox(-1.5F, -1.25F, 2.95F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F))
		.texOffs(32, 23).addBox(-0.5F, -1.25F, 3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition MGear1Connection5 = MGear1Wheel2.addOrReplaceChild("MGear1Connection5", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition WheelTooth_r25 = MGear1Connection5.addOrReplaceChild("WheelTooth_r25", CubeListBuilder.create().texOffs(71, 51).addBox(-4.55F, -1.26F, 1.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(62, 67).addBox(-3.95F, -1.26F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(3.6607F, 0.0F, -1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r26 = MGear1Connection5.addOrReplaceChild("WheelTooth_r26", CubeListBuilder.create().texOffs(10, 71).addBox(-0.25F, -0.51F, -1.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(34, 68).addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(1.1545F, -0.75F, -3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r21 = MGear1Connection5.addOrReplaceChild("WheelSeg_r21", CubeListBuilder.create().texOffs(44, 71).addBox(-1.35F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(1.1545F, -0.75F, -3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection6 = MGear1Wheel2.addOrReplaceChild("MGear1Connection6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition WheelTooth_r27 = MGear1Connection6.addOrReplaceChild("WheelTooth_r27", CubeListBuilder.create().texOffs(71, 49).addBox(-4.55F, -1.26F, 1.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(62, 67).addBox(-3.95F, -1.26F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.6607F, 0.75F, -1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r28 = MGear1Connection6.addOrReplaceChild("WheelTooth_r28", CubeListBuilder.create().texOffs(0, 71).addBox(-0.25F, -0.51F, -1.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(34, 68).addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.8455F, 0.0F, -3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r22 = MGear1Connection6.addOrReplaceChild("WheelSeg_r22", CubeListBuilder.create().texOffs(44, 71).addBox(-1.35F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.8455F, 0.0F, -3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection7 = MGear1Wheel2.addOrReplaceChild("MGear1Connection7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition WheelTooth_r29 = MGear1Connection7.addOrReplaceChild("WheelTooth_r29", CubeListBuilder.create().texOffs(71, 47).addBox(-4.55F, -1.26F, 1.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(62, 67).addBox(-3.95F, -1.26F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.6607F, 0.75F, -1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r30 = MGear1Connection7.addOrReplaceChild("WheelTooth_r30", CubeListBuilder.create().texOffs(70, 70).addBox(-0.25F, -0.51F, -1.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(34, 68).addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.8455F, 0.0F, -3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r23 = MGear1Connection7.addOrReplaceChild("WheelSeg_r23", CubeListBuilder.create().texOffs(44, 71).addBox(-1.35F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.8455F, 0.0F, -3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection8 = MGear1Wheel2.addOrReplaceChild("MGear1Connection8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition WheelTooth_r31 = MGear1Connection8.addOrReplaceChild("WheelTooth_r31", CubeListBuilder.create().texOffs(71, 45).addBox(-4.55F, -1.26F, 1.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(62, 67).addBox(-3.95F, -1.26F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.6607F, 0.75F, -1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r32 = MGear1Connection8.addOrReplaceChild("WheelTooth_r32", CubeListBuilder.create().texOffs(62, 70).addBox(-0.25F, -0.51F, -1.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(34, 68).addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.8455F, 0.0F, -3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r24 = MGear1Connection8.addOrReplaceChild("WheelSeg_r24", CubeListBuilder.create().texOffs(44, 71).addBox(-1.35F, -0.5F, -0.65F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-1.8455F, 0.0F, -3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition TorsoTopGears = TorsoTop.addOrReplaceChild("TorsoTopGears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition MediumGear = TorsoTopGears.addOrReplaceChild("MediumGear", CubeListBuilder.create().texOffs(34, 64).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(1.0F, -1.5F, 0.5F, 0.0F, 0.0F, 1.1781F));

		PartDefinition MGear1Spoke = MediumGear.addOrReplaceChild("MGear1Spoke", CubeListBuilder.create().texOffs(40, 64).mirror().addBox(-3.25F, -1.25F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(63, 44).mirror().addBox(0.25F, -1.25F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(19, 64).mirror().addBox(-0.5F, -1.25F, -3.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(64, 0).mirror().addBox(-0.5F, -1.25F, 0.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition MGear1Wheel = MediumGear.addOrReplaceChild("MGear1Wheel", CubeListBuilder.create().texOffs(63, 52).mirror().addBox(-3.95F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(69, 0).mirror().addBox(-4.6F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(63, 30).mirror().addBox(-1.5F, -1.25F, 2.95F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(32, 8).mirror().addBox(-0.5F, -1.25F, 3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(63, 52).mirror().addBox(2.95F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(68, 63).mirror().addBox(3.6F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(63, 30).mirror().addBox(-1.5F, -1.25F, -3.95F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(0, 39).mirror().addBox(-0.5F, -1.25F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition MGear1Connection1 = MGear1Wheel.addOrReplaceChild("MGear1Connection1", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition WheelTooth_r33 = MGear1Connection1.addOrReplaceChild("WheelTooth_r33", CubeListBuilder.create().texOffs(71, 51).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-3.6607F, 0.0F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r34 = MGear1Connection1.addOrReplaceChild("WheelTooth_r34", CubeListBuilder.create().texOffs(10, 71).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-1.1545F, -0.75F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r25 = MGear1Connection1.addOrReplaceChild("WheelSeg_r25", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-1.1545F, -0.75F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection2 = MGear1Wheel.addOrReplaceChild("MGear1Connection2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition WheelTooth_r35 = MGear1Connection2.addOrReplaceChild("WheelTooth_r35", CubeListBuilder.create().texOffs(71, 49).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-0.6607F, 0.75F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r36 = MGear1Connection2.addOrReplaceChild("WheelTooth_r36", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r26 = MGear1Connection2.addOrReplaceChild("WheelSeg_r26", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection3 = MGear1Wheel.addOrReplaceChild("MGear1Connection3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition WheelTooth_r37 = MGear1Connection3.addOrReplaceChild("WheelTooth_r37", CubeListBuilder.create().texOffs(71, 47).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-0.6607F, 0.75F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r38 = MGear1Connection3.addOrReplaceChild("WheelTooth_r38", CubeListBuilder.create().texOffs(70, 70).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r27 = MGear1Connection3.addOrReplaceChild("WheelSeg_r27", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection4 = MGear1Wheel.addOrReplaceChild("MGear1Connection4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition WheelTooth_r39 = MGear1Connection4.addOrReplaceChild("WheelTooth_r39", CubeListBuilder.create().texOffs(71, 45).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-0.6607F, 0.75F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r40 = MGear1Connection4.addOrReplaceChild("WheelTooth_r40", CubeListBuilder.create().texOffs(62, 70).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r28 = MGear1Connection4.addOrReplaceChild("WheelSeg_r28", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SmallGear = TorsoTopGears.addOrReplaceChild("SmallGear", CubeListBuilder.create().texOffs(50, 70).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -0.5F, 2.0F, 0.0F, 0.0F, -1.0908F));

		PartDefinition SGear1Spoke = SmallGear.addOrReplaceChild("SGear1Spoke", CubeListBuilder.create().texOffs(25, 67).mirror().addBox(-0.5F, -1.0F, 0.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(66, 67).mirror().addBox(0.25F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(58, 66).mirror().addBox(-0.5F, -1.0F, -2.25F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(29, 67).mirror().addBox(-2.25F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition SGear1Wheel = SmallGear.addOrReplaceChild("SGear1Wheel", CubeListBuilder.create().texOffs(66, 56).mirror().addBox(-1.0F, -1.0F, -2.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(70, 43).mirror().addBox(-0.5F, -1.0F, -3.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(40, 66).mirror().addBox(-2.75F, -1.01F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(70, 29).mirror().addBox(-3.2F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(40, 66).mirror().addBox(1.75F, -1.01F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(68, 50).mirror().addBox(2.2F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(70, 17).mirror().addBox(-0.5F, -1.0F, 2.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(66, 56).mirror().addBox(-1.0F, -1.01F, 1.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offset(0.0F, 0.5F, 0.0F));

		PartDefinition SGear1Connection1 = SGear1Wheel.addOrReplaceChild("SGear1Connection1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Wheeltooth_r41 = SGear1Connection1.addOrReplaceChild("Wheeltooth_r41", CubeListBuilder.create().texOffs(16, 70).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r42 = SGear1Connection1.addOrReplaceChild("Wheeltooth_r42", CubeListBuilder.create().texOffs(68, 48).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r29 = SGear1Connection1.addOrReplaceChild("WheelSeg_r29", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r30 = SGear1Connection1.addOrReplaceChild("WheelSeg_r30", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.505F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r31 = SGear1Connection1.addOrReplaceChild("WheelSeg_r31", CubeListBuilder.create().texOffs(32, 23).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SGear1Connection2 = SGear1Wheel.addOrReplaceChild("SGear1Connection2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Wheeltooth_r43 = SGear1Connection2.addOrReplaceChild("Wheeltooth_r43", CubeListBuilder.create().texOffs(70, 15).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r44 = SGear1Connection2.addOrReplaceChild("Wheeltooth_r44", CubeListBuilder.create().texOffs(44, 66).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r32 = SGear1Connection2.addOrReplaceChild("WheelSeg_r32", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.52F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r33 = SGear1Connection2.addOrReplaceChild("WheelSeg_r33", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r34 = SGear1Connection2.addOrReplaceChild("WheelSeg_r34", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.25F, -0.505F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SGear1Connection3 = SGear1Wheel.addOrReplaceChild("SGear1Connection3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Wheeltooth_r45 = SGear1Connection3.addOrReplaceChild("Wheeltooth_r45", CubeListBuilder.create().texOffs(70, 13).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r46 = SGear1Connection3.addOrReplaceChild("Wheeltooth_r46", CubeListBuilder.create().texOffs(62, 18).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r35 = SGear1Connection3.addOrReplaceChild("WheelSeg_r35", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.51F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r36 = SGear1Connection3.addOrReplaceChild("WheelSeg_r36", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.505F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r37 = SGear1Connection3.addOrReplaceChild("WheelSeg_r37", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SGear1Connection4 = SGear1Wheel.addOrReplaceChild("SGear1Connection4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Wheeltooth_r47 = SGear1Connection4.addOrReplaceChild("Wheeltooth_r47", CubeListBuilder.create().texOffs(70, 11).mirror().addBox(0.0F, -0.51F, 0.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(1.6228F, -0.5F, -3.8036F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Wheeltooth_r48 = SGear1Connection4.addOrReplaceChild("Wheeltooth_r48", CubeListBuilder.create().texOffs(22, 60).mirror().addBox(-1.875F, -0.51F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.7463F, -0.5F, -1.7047F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r38 = SGear1Connection4.addOrReplaceChild("WheelSeg_r38", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-2.25F, -0.515F, -1.4F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.528F, -0.49F, -1.8971F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r39 = SGear1Connection4.addOrReplaceChild("WheelSeg_r39", CubeListBuilder.create().texOffs(52, 18).mirror().addBox(-0.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(0.8114F, -0.5F, -2.1518F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelSeg_r40 = SGear1Connection4.addOrReplaceChild("WheelSeg_r40", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.25F, -0.51F, -1.9886F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(3.9233F, -0.5F, -1.8164F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Legs = Base.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RLeg = Legs.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0F, -0.01F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 58).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition RLSeg2 = RLeg.addOrReplaceChild("RLSeg2", CubeListBuilder.create().texOffs(50, 56).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RLSeg2Solo = RLSeg2.addOrReplaceChild("RLSeg2Solo", CubeListBuilder.create().texOffs(51, 28).addBox(-2.0F, -6.01F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightLegSeg1Gears = RLeg.addOrReplaceChild("RightLegSeg1Gears", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition MediumGear3 = RightLegSeg1Gears.addOrReplaceChild("MediumGear3", CubeListBuilder.create().texOffs(34, 64).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 4.5F, 0.5F, 0.0F, 0.0F, -1.7017F));

		PartDefinition MGear1Spoke3 = MediumGear3.addOrReplaceChild("MGear1Spoke3", CubeListBuilder.create().texOffs(40, 64).mirror().addBox(-3.25F, -1.25F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(63, 44).mirror().addBox(0.25F, -1.25F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(19, 64).mirror().addBox(-0.5F, -1.25F, -3.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(64, 0).mirror().addBox(-0.5F, -1.25F, 0.25F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition MGear1Wheel3 = MediumGear3.addOrReplaceChild("MGear1Wheel3", CubeListBuilder.create().texOffs(63, 52).mirror().addBox(-3.95F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(69, 0).mirror().addBox(-4.6F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(63, 30).mirror().addBox(-1.5F, -1.25F, 2.95F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(32, 8).mirror().addBox(-0.5F, -1.25F, 3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(63, 52).mirror().addBox(2.95F, -1.25F, -1.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(68, 58).mirror().addBox(3.6F, -1.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(63, 30).mirror().addBox(-1.5F, -1.25F, -3.95F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false)
		.texOffs(0, 39).mirror().addBox(-0.5F, -1.25F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition MGear1Connection9 = MGear1Wheel3.addOrReplaceChild("MGear1Connection9", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition WheelTooth_r49 = MGear1Connection9.addOrReplaceChild("WheelTooth_r49", CubeListBuilder.create().texOffs(71, 51).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-3.6607F, 0.0F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r50 = MGear1Connection9.addOrReplaceChild("WheelTooth_r50", CubeListBuilder.create().texOffs(10, 71).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-1.1545F, -0.75F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r41 = MGear1Connection9.addOrReplaceChild("WheelSeg_r41", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-1.1545F, -0.75F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection10 = MGear1Wheel3.addOrReplaceChild("MGear1Connection10", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition WheelTooth_r51 = MGear1Connection10.addOrReplaceChild("WheelTooth_r51", CubeListBuilder.create().texOffs(71, 49).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-0.6607F, 0.75F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r52 = MGear1Connection10.addOrReplaceChild("WheelTooth_r52", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r42 = MGear1Connection10.addOrReplaceChild("WheelSeg_r42", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection11 = MGear1Wheel3.addOrReplaceChild("MGear1Connection11", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition WheelTooth_r53 = MGear1Connection11.addOrReplaceChild("WheelTooth_r53", CubeListBuilder.create().texOffs(71, 47).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-0.6607F, 0.75F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r54 = MGear1Connection11.addOrReplaceChild("WheelTooth_r54", CubeListBuilder.create().texOffs(70, 70).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r43 = MGear1Connection11.addOrReplaceChild("WheelSeg_r43", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition MGear1Connection12 = MGear1Wheel3.addOrReplaceChild("MGear1Connection12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition WheelTooth_r55 = MGear1Connection12.addOrReplaceChild("WheelTooth_r55", CubeListBuilder.create().texOffs(71, 45).mirror().addBox(3.55F, -1.26F, -2.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(62, 67).mirror().addBox(2.95F, -1.26F, -2.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(-0.6607F, 0.75F, 1.0954F, 0.0F, -0.6109F, 0.0F));

		PartDefinition WheelTooth_r56 = MGear1Connection12.addOrReplaceChild("WheelTooth_r56", CubeListBuilder.create().texOffs(62, 70).mirror().addBox(-0.75F, -0.51F, 0.15F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 68).mirror().addBox(-1.0F, -0.51F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.6109F, 0.0F));

		PartDefinition WheelSeg_r44 = MGear1Connection12.addOrReplaceChild("WheelSeg_r44", CubeListBuilder.create().texOffs(44, 71).mirror().addBox(0.35F, -0.5F, -0.35F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)).mirror(false), PartPose.offsetAndRotation(1.8455F, 0.0F, 3.0258F, 0.0F, 0.7854F, 0.0F));

		PartDefinition LLeg = Legs.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -0.01F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(50, 56).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition LLSeg2 = LLeg.addOrReplaceChild("LLSeg2", CubeListBuilder.create().texOffs(14, 58).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LLSeg2Solo = LLSeg2.addOrReplaceChild("LLSeg2Solo", CubeListBuilder.create().texOffs(44, 46).addBox(-2.0F, -6.01F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Reconstructed.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Reconstructed;
	}
}