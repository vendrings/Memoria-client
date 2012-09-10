package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ModelSign;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntitySignRenderer extends TileEntitySpecialRenderer {

   private ModelSign field_1413_b = new ModelSign();


   public void func_932_a(TileEntitySign p_932_1_, double p_932_2_, double p_932_4_, double p_932_6_, float p_932_8_) {
      Block var9 = p_932_1_.func_478_g();
      GL11.glPushMatrix();
      float var10 = 0.6666667F;
      float var12;
      if(var9 == Block.field_443_aE) {
         GL11.glTranslatef((float)p_932_2_ + 0.5F, (float)p_932_4_ + 0.75F * var10, (float)p_932_6_ + 0.5F);
         float var11 = (float)(p_932_1_.func_479_f() * 360) / 16.0F;
         GL11.glRotatef(-var11, 0.0F, 1.0F, 0.0F);
         this.field_1413_b.field_1345_b.field_1403_h = true;
      } else {
         int var16 = p_932_1_.func_479_f();
         var12 = 0.0F;
         if(var16 == 2) {
            var12 = 180.0F;
         }

         if(var16 == 4) {
            var12 = 90.0F;
         }

         if(var16 == 5) {
            var12 = -90.0F;
         }

         GL11.glTranslatef((float)p_932_2_ + 0.5F, (float)p_932_4_ + 0.75F * var10, (float)p_932_6_ + 0.5F);
         GL11.glRotatef(-var12, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
         this.field_1413_b.field_1345_b.field_1403_h = false;
      }

      this.func_6507_a("/item/sign.png");
      GL11.glPushMatrix();
      GL11.glScalef(var10, -var10, -var10);
      this.field_1413_b.func_887_a();
      GL11.glPopMatrix();
      FontRenderer var17 = this.func_6508_a();
      var12 = 0.016666668F * var10;
      GL11.glTranslatef(0.0F, 0.5F * var10, 0.07F * var10);
      GL11.glScalef(var12, -var12, var12);
      GL11.glNormal3f(0.0F, 0.0F, -1.0F * var12);
      GL11.glDepthMask(false);
      byte var13 = 0;

      for(int var14 = 0; var14 < p_932_1_.field_826_a.length; ++var14) {
         String var15 = p_932_1_.field_826_a[var14];
         if(var14 == p_932_1_.field_825_b) {
            var15 = "> " + var15 + " <";
            var17.func_873_b(var15, -var17.func_871_a(var15) / 2, var14 * 10 - p_932_1_.field_826_a.length * 5, var13);
         } else {
            var17.func_873_b(var15, -var17.func_871_a(var15) / 2, var14 * 10 - p_932_1_.field_826_a.length * 5, var13);
         }
      }

      GL11.glDepthMask(true);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_930_a(TileEntity p_930_1_, double p_930_2_, double p_930_4_, double p_930_6_, float p_930_8_) {
      this.func_932_a((TileEntitySign)p_930_1_, p_930_2_, p_930_4_, p_930_6_, p_930_8_);
   }
}
