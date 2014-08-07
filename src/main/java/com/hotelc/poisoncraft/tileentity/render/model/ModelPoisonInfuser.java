package com.hotelc.poisoncraft.tileentity.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * This file created by Alex Brooke
 * please seek the author's permission before
 * distributing this software.
 * 'Do you know Java? Because your method body is sexy'
 * :3
 */
public class ModelPoisonInfuser extends ModelBase {
    //fields
    ModelRenderer leg_BR;
    ModelRenderer leg_BL;
    ModelRenderer leg_FR;
    ModelRenderer leg_FL;
    ModelRenderer base;
    ModelRenderer wall_F;
    ModelRenderer wall_B;
    ModelRenderer wall_L;
    ModelRenderer wall_R;
    ModelRenderer rod;
    ModelRenderer platform_FR;
    ModelRenderer platform_FL;
    ModelRenderer platform_BR;
    ModelRenderer platform_BL;
    ModelRenderer pwall_BL;
    ModelRenderer pwall_BR;
    ModelRenderer pwall_FR;
    ModelRenderer pwall_FL;
    ModelRenderer pwall_RF;
    ModelRenderer pwall_RB;
    ModelRenderer pwall_LB;
    ModelRenderer pwall_LF;
    ModelRenderer jwall_B;
    ModelRenderer jwall_F;
    ModelRenderer jwall_R;
    ModelRenderer jwall_L;

    public ModelPoisonInfuser() {
        textureWidth = 2560;
        textureHeight = 320;

        leg_BR = new ModelRenderer(this, 119, 8);
        leg_BR.addBox(1F, 0F, 0F, 2, 2, 2);
        leg_BR.setRotationPoint(5F, 22F, 6F);
        leg_BR.setTextureSize(2560, 320);
        leg_BR.mirror = true;
        setRotation(leg_BR, 0F, 0F, 0F);
        leg_BL = new ModelRenderer(this, 119, 8);
        leg_BL.addBox(0F, 0F, 0F, 2, 2, 2);
        leg_BL.setRotationPoint(-8F, 22F, 6F);
        leg_BL.setTextureSize(2560, 320);
        leg_BL.mirror = true;
        setRotation(leg_BL, 0F, 0F, 0F);
        leg_FR = new ModelRenderer(this, 119, 8);
        leg_FR.addBox(0F, 0F, 0F, 2, 2, 2);
        leg_FR.setRotationPoint(6F, 22F, -8F);
        leg_FR.setTextureSize(2560, 320);
        leg_FR.mirror = true;
        setRotation(leg_FR, 0F, 0F, 0F);
        leg_FL = new ModelRenderer(this, 119, 8);
        leg_FL.addBox(0F, 0F, 0F, 2, 2, 2);
        leg_FL.setRotationPoint(-8F, 22F, -8F);
        leg_FL.setTextureSize(2560, 320);
        leg_FL.mirror = true;
        setRotation(leg_FL, 0F, 0F, 0F);
        base = new ModelRenderer(this, 0, 0);
        base.addBox(0F, 0F, 0F, 16, 1, 16);
        base.setRotationPoint(-8F, 21F, -8F);
        base.setTextureSize(2560, 320);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        wall_F = new ModelRenderer(this, 95, 0);
        wall_F.addBox(0F, 0F, 0F, 15, 7, 1);
        wall_F.setRotationPoint(-8F, 14F, -8F);
        wall_F.setTextureSize(2560, 320);
        wall_F.mirror = true;
        setRotation(wall_F, 0F, 0F, 0F);
        wall_B = new ModelRenderer(this, 95, 0);
        wall_B.addBox(0F, 0F, 0F, 15, 7, 1);
        wall_B.setRotationPoint(-7F, 14F, 7F);
        wall_B.setTextureSize(2560, 320);
        wall_B.mirror = true;
        setRotation(wall_B, 0F, 0F, 0F);
        wall_L = new ModelRenderer(this, 127, 0);
        wall_L.addBox(0F, 0F, 0F, 1, 7, 15);
        wall_L.setRotationPoint(-8F, 14F, -7F);
        wall_L.setTextureSize(2560, 320);
        wall_L.mirror = true;
        setRotation(wall_L, 0F, 0F, 0F);
        wall_R = new ModelRenderer(this, 127, 0);
        wall_R.addBox(0F, 0F, 0F, 1, 7, 15);
        wall_R.setRotationPoint(7F, 14F, -8F);
        wall_R.setTextureSize(2560, 320);
        wall_R.mirror = true;
        setRotation(wall_R, 0F, 0F, 0F);
        rod = new ModelRenderer(this, 87, 0);
        rod.addBox(0F, 0F, 0F, 2, 14, 2);
        rod.setRotationPoint(-1F, 7F, -1F);
        rod.setTextureSize(2560, 320);
        rod.mirror = true;
        setRotation(rod, 0F, 0F, 0F);
        platform_FR = new ModelRenderer(this, 99, 8);
        platform_FR.addBox(0F, 0F, 0F, 3, 1, 3);
        platform_FR.setRotationPoint(1F, 11F, -4F);
        platform_FR.setTextureSize(2560, 320);
        platform_FR.mirror = true;
        setRotation(platform_FR, 0F, 0F, 0.0174533F);
        platform_FL = new ModelRenderer(this, 98, 8);
        platform_FL.addBox(0F, 0F, 0F, 3, 1, 3);
        platform_FL.setRotationPoint(-4F, 11F, -4F);
        platform_FL.setTextureSize(2560, 320);
        platform_FL.mirror = true;
        setRotation(platform_FL, 0F, 0F, 0.0174533F);
        platform_BR = new ModelRenderer(this, 98, 8);
        platform_BR.addBox(0F, 0F, 0F, 3, 1, 3);
        platform_BR.setRotationPoint(1F, 11F, 1F);
        platform_BR.setTextureSize(2560, 320);
        platform_BR.mirror = true;
        setRotation(platform_BR, 0F, 0F, 0.0174533F);
        platform_BL = new ModelRenderer(this, 98, 8);
        platform_BL.addBox(0F, 0F, 0F, 3, 1, 3);
        platform_BL.setRotationPoint(-4F, 11F, 1F);
        platform_BL.setTextureSize(2560, 320);
        platform_BL.mirror = true;
        setRotation(platform_BL, 0F, 0F, 0.0174533F);
        pwall_BL = new ModelRenderer(this, 111, 8);
        pwall_BL.addBox(0F, 0F, 0F, 3, 3, 1);
        pwall_BL.setRotationPoint(-4F, 9F, 4F);
        pwall_BL.setTextureSize(2560, 320);
        pwall_BL.mirror = true;
        setRotation(pwall_BL, 0F, 0F, 0F);
        pwall_BR = new ModelRenderer(this, 117, 12);
        pwall_BR.addBox(0F, 0F, 0F, 4, 3, 1);
        pwall_BR.setRotationPoint(1F, 9F, 4F);
        pwall_BR.setTextureSize(2560, 320);
        pwall_BR.mirror = true;
        setRotation(pwall_BR, 0F, 0F, 0F);
        pwall_FR = new ModelRenderer(this, 111, 8);
        pwall_FR.addBox(0F, 0F, 0F, 3, 3, 1);
        pwall_FR.setRotationPoint(1F, 9F, -5F);
        pwall_FR.setTextureSize(2560, 320);
        pwall_FR.mirror = true;
        setRotation(pwall_FR, 0F, 0F, 0F);
        pwall_FL = new ModelRenderer(this, 117, 12);
        pwall_FL.addBox(0F, 0F, 0F, 4, 3, 1);
        pwall_FL.setRotationPoint(-5F, 9F, -5F);
        pwall_FL.setTextureSize(2560, 320);
        pwall_FL.mirror = true;
        setRotation(pwall_FL, 0F, 0F, 0F);
        pwall_RF = new ModelRenderer(this, 77, 0);
        pwall_RF.addBox(0F, 0F, 0F, 1, 3, 4);
        pwall_RF.setRotationPoint(4F, 9F, -5F);
        pwall_RF.setTextureSize(2560, 320);
        pwall_RF.mirror = true;
        setRotation(pwall_RF, 0F, 0F, 0F);
        pwall_RB = new ModelRenderer(this, 69, 0);
        pwall_RB.addBox(0F, 0F, 0F, 1, 3, 3);
        pwall_RB.setRotationPoint(4F, 9F, 1F);
        pwall_RB.setTextureSize(2560, 320);
        pwall_RB.mirror = true;
        setRotation(pwall_RB, 0F, 0F, 0F);
        pwall_LB = new ModelRenderer(this, 77, 0);
        pwall_LB.addBox(0F, 0F, 0F, 1, 3, 4);
        pwall_LB.setRotationPoint(-5F, 9F, 1F);
        pwall_LB.setTextureSize(2560, 320);
        pwall_LB.mirror = true;
        setRotation(pwall_LB, 0F, 0F, 0F);
        pwall_LF = new ModelRenderer(this, 69, 0);
        pwall_LF.addBox(0F, 0F, 0F, 1, 3, 3);
        pwall_LF.setRotationPoint(-5F, 9F, -4F);
        pwall_LF.setTextureSize(2560, 320);
        pwall_LF.mirror = true;
        setRotation(pwall_LF, 0F, 0F, 0F);
        jwall_B = new ModelRenderer(this, 75, 7);
        jwall_B.addBox(0F, 0F, 0F, 2, 2, 1);
        jwall_B.setRotationPoint(-1F, 9F, 4F);
        jwall_B.setTextureSize(2560, 320);
        jwall_B.mirror = true;
        setRotation(jwall_B, 0F, 0F, 0F);
        jwall_F = new ModelRenderer(this, 75, 7);
        jwall_F.addBox(0F, 0F, 0F, 2, 2, 1);
        jwall_F.setRotationPoint(-1F, 9F, -5F);
        jwall_F.setTextureSize(2560, 320);
        jwall_F.mirror = true;
        setRotation(jwall_F, 0F, 0F, 0F);
        jwall_R = new ModelRenderer(this, 81, 7);
        jwall_R.addBox(0F, 0F, 0F, 1, 2, 2);
        jwall_R.setRotationPoint(4F, 9F, -1F);
        jwall_R.setTextureSize(2560, 320);
        jwall_R.mirror = true;
        setRotation(jwall_R, 0F, 0F, 0F);
        jwall_L = new ModelRenderer(this, 81, 7);
        jwall_L.addBox(0F, 0F, 0F, 1, 2, 2);
        jwall_L.setRotationPoint(-5F, 9F, -1F);
        jwall_L.setTextureSize(2560, 320);
        jwall_L.mirror = true;
        setRotation(jwall_L, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        leg_BR.render(f5);
        leg_BL.render(f5);
        leg_FR.render(f5);
        leg_FL.render(f5);
        base.render(f5);
        wall_F.render(f5);
        wall_B.render(f5);
        wall_L.render(f5);
        wall_R.render(f5);
        rod.render(f5);
        platform_FR.render(f5);
        platform_FL.render(f5);
        platform_BR.render(f5);
        platform_BL.render(f5);
        pwall_BL.render(f5);
        pwall_BR.render(f5);
        pwall_FR.render(f5);
        pwall_FL.render(f5);
        pwall_RF.render(f5);
        pwall_RB.render(f5);
        pwall_LB.render(f5);
        pwall_LF.render(f5);
        jwall_B.render(f5);
        jwall_F.render(f5);
        jwall_R.render(f5);
        jwall_L.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}

