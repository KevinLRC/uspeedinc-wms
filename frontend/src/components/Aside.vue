<template>
  <div>
    <el-menu class="el-menu-vertical-demo"
             style="width: 200px; min-height: calc(100vh - 50px)"
             :default-active="path"
             router>
      <el-sub-menu index="shunwei">
        <template #title>顺为</template>
        <el-menu-item index="/sw-product-details">商品详情</el-menu-item>
        <el-menu-item index="/sw-stock">库存</el-menu-item>
        <el-menu-item index="shunwei-single">一件代发</el-menu-item>
        <el-menu-item index="shunwei-label">换标</el-menu-item>
      </el-sub-menu>

      <el-sub-menu index="container">
        <template #title>
          <span>货柜</span>
        </template>
        <el-menu-item index="2-1">德容</el-menu-item>
        <el-menu-item index="2-2">Sugar</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside",
  data (){
    return {
      path: this.$route.path
    }
  }
}
</script>

<style scoped>

</style>

