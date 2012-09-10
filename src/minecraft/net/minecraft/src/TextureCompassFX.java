package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import cpw.mods.fml.client.FMLTextureFX;
import net.minecraft.client.Minecraft;

public class TextureCompassFX extends FMLTextureFX
{
    /** A reference to the Minecraft object. */
    private Minecraft mc;

    /** Holds the image of the compass from items.png in rgb format. */
    private int[] compassIconImageData;
    private double field_4229_i;
    private double field_4228_j;

    public TextureCompassFX(Minecraft par1Minecraft)
    {
        super(Item.compass.getIconFromDamage(0));
        this.mc = par1Minecraft;
        this.tileImage = 1;
        setup();
    }

    @Override
    public void setup()
    {
        super.setup();
        compassIconImageData = new int[tileSizeSquare];
        try
        {
            BufferedImage var2 = ImageIO.read(mc.texturePackList.selectedTexturePack.getResourceAsStream("/gui/items.png"));
            int var3 = this.iconIndex % 16 * tileSizeBase;
            int var4 = this.iconIndex / 16 * tileSizeBase;
            var2.getRGB(var3, var4, tileSizeBase, tileSizeBase, this.compassIconImageData, 0, tileSizeBase);
        }
        catch (IOException var5)
        {
            var5.printStackTrace();
        }
    }

    public void onTick()
    {
        for (int var1 = 0; var1 < tileSizeSquare; ++var1)
        {
            int var2 = this.compassIconImageData[var1] >> 24 & 255;
            int var3 = this.compassIconImageData[var1] >> 16 & 255;
            int var4 = this.compassIconImageData[var1] >> 8 & 255;
            int var5 = this.compassIconImageData[var1] >> 0 & 255;

            if (this.anaglyphEnabled)
            {
                int var6 = (var3 * 30 + var4 * 59 + var5 * 11) / 100;
                int var7 = (var3 * 30 + var4 * 70) / 100;
                int var8 = (var3 * 30 + var5 * 70) / 100;
                var3 = var6;
                var4 = var7;
                var5 = var8;
            }

            this.imageData[var1 * 4 + 0] = (byte)var3;
            this.imageData[var1 * 4 + 1] = (byte)var4;
            this.imageData[var1 * 4 + 2] = (byte)var5;
            this.imageData[var1 * 4 + 3] = (byte)var2;
        }

        double var20 = 0.0D;

        if (this.mc.theWorld != null && this.mc.thePlayer != null)
        {
            ChunkCoordinates var21 = this.mc.theWorld.getSpawnPoint();
            double var23 = (double)var21.posX - this.mc.thePlayer.posX;
            double var25 = (double)var21.posZ - this.mc.thePlayer.posZ;
            var20 = (double)(this.mc.thePlayer.rotationYaw - 90.0F) * Math.PI / 180.0D - Math.atan2(var25, var23);

            if (!this.mc.theWorld.worldProvider.func_48217_e())
            {
                var20 = Math.random() * Math.PI * 2.0D;
            }
        }

        double var22;

        for (var22 = var20 - this.field_4229_i; var22 < -Math.PI; var22 += (Math.PI * 2D))
        {
            ;
        }

        while (var22 >= Math.PI)
        {
            var22 -= (Math.PI * 2D);
        }

        if (var22 < -1.0D)
        {
            var22 = -1.0D;
        }

        if (var22 > 1.0D)
        {
            var22 = 1.0D;
        }

        this.field_4228_j += var22 * 0.1D;
        this.field_4228_j *= 0.8D;
        this.field_4229_i += this.field_4228_j;
        double var24 = Math.sin(this.field_4229_i);
        double var26 = Math.cos(this.field_4229_i);
        int var9;
        int var10;
        int var11;
        int var12;
        int var13;
        int var14;
        int var15;
        int var17;
        short var16;
        int var19;
        int var18;

        for (var9 = -(tileSizeBase >> 2); var9 <= (tileSizeBase >> 2); ++var9)
        {
            var10 = (int)((tileSizeBase >> 1) + 0.5D + var26 * (double)var9 * 0.3D);
            var11 = (int)((tileSizeBase >> 1) - 0.5D - var24 * (double)var9 * 0.3D * 0.5D);
            var12 = var11 * tileSizeBase + var10;
            var13 = 100;
            var14 = 100;
            var15 = 100;
            var16 = 255;

            if (this.anaglyphEnabled)
            {
                var17 = (var13 * 30 + var14 * 59 + var15 * 11) / 100;
                var18 = (var13 * 30 + var14 * 70) / 100;
                var19 = (var13 * 30 + var15 * 70) / 100;
                var13 = var17;
                var14 = var18;
                var15 = var19;
            }

            this.imageData[var12 * 4 + 0] = (byte)var13;
            this.imageData[var12 * 4 + 1] = (byte)var14;
            this.imageData[var12 * 4 + 2] = (byte)var15;
            this.imageData[var12 * 4 + 3] = (byte)var16;
        }

        for (var9 = -(tileSizeBase>>2); var9 <= tileSizeBase; ++var9)
        {
            var10 = (int)((tileSizeBase >> 1) + 0.5D + var24 * (double)var9 * 0.3D);
            var11 = (int)((tileSizeBase >> 1) - 0.5D + var26 * (double)var9 * 0.3D * 0.5D);
            var12 = var11 * tileSizeBase + var10;
            var13 = var9 >= 0 ? 255 : 100;
            var14 = var9 >= 0 ? 20 : 100;
            var15 = var9 >= 0 ? 20 : 100;
            var16 = 255;

            if (this.anaglyphEnabled)
            {
                var17 = (var13 * 30 + var14 * 59 + var15 * 11) / 100;
                var18 = (var13 * 30 + var14 * 70) / 100;
                var19 = (var13 * 30 + var15 * 70) / 100;
                var13 = var17;
                var14 = var18;
                var15 = var19;
            }

            this.imageData[var12 * 4 + 0] = (byte)var13;
            this.imageData[var12 * 4 + 1] = (byte)var14;
            this.imageData[var12 * 4 + 2] = (byte)var15;
            this.imageData[var12 * 4 + 3] = (byte)var16;
        }
    }
}
