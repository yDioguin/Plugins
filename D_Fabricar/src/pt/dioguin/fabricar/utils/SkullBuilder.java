/*    */ package pt.dioguin.fabricar.utils;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.SkullType;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.inventory.meta.SkullMeta;
/*    */ 
/*    */ public class SkullBuilder
/*    */   extends ItemBuilder {
/*    */   private SkullMeta skullMeta;
/*    */   
/*    */   public SkullBuilder() {
/* 14 */     super(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
/* 15 */     this.skullMeta = (SkullMeta)this.itemMeta;
/*    */   }
/*    */   
/*    */   public SkullBuilder setOwner(String owner) {
/* 19 */     this.skullMeta = (SkullMeta)this.itemMeta;
/* 20 */     this.skullMeta.setOwner(owner);
/* 21 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack build() {
/* 26 */     this.skullMeta = (SkullMeta)this.itemMeta;
/* 27 */     this.itemStack.setItemMeta((ItemMeta)this.skullMeta);
/* 28 */     return this.itemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Diogo Lima\Desktop\Coisas\Plugins\Meus Plugins\D_Encantar.jar!\me\items\SkullBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */