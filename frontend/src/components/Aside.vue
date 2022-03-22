<template>
  <div>
    <el-col :span="2222">
      <el-menu

          class="el-menu-vertical-demo"
          style="width: 200px; min-height: calc(100vh - 50px)">
        <el-sub-menu index="1">
          <template #title>
            <span>顺为</span>
          </template>
          <el-menu-item index="1-1">商品详情</el-menu-item>
          <el-menu-item index="1-2">库存</el-menu-item>
          <el-menu-item index="1-3">一件代发</el-menu-item>
          <el-menu-item index="1-4">换标</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="2">
          <template #title>
            <span>卡派</span>
          </template>
          <el-menu-item index="2-1">德容</el-menu-item>
          <el-menu-item index="2-2">Sugar</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>

