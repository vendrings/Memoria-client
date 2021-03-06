package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentArrowInfinite extends Enchantment {

   public EnchantmentArrowInfinite(int p_i644_1_, int p_i644_2_) {
      super(p_i644_1_, p_i644_2_, EnumEnchantmentType.bow);
      this.func_40494_a("arrowInfinite");
   }

   public int func_40492_a(int p_40492_1_) {
      return 20;
   }

   public int func_40489_b(int p_40489_1_) {
      return 50;
   }

   public int func_40491_a() {
      return 1;
   }
}
