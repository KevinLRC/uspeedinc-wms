<template>
  <div class="home" style="padding: 10px">
    <div style="margin: 10px 0;">
      <el-button type="primary" @click="addProduct">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-input v-model="keyword" placeholder="关键字" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="load">搜索</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="skuNo" label="skuNo" sortable/>
      <el-table-column prop="skuName" label="skuName"/>
      <el-table-column prop="brandName" label="brandName"/>

      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDelete">
            <el-popconfirm title="Are you sure to delete this?">
              <template #reference>
                删除
              </template>
            </el-popconfirm>
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px">

      <el-pagination
          v-model:currentPage="currentPage"
          v-model:page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          layout="total,  prev, pager, next, jumper"
      />

      <el-dialog v-model="dialogVisible" title="Tips" width="30%">
        <el-form ref="form" :model="form" label-width="120px">
          <el-form-item label="skuNo">
            <el-input v-model="form.skuNo"/>
          </el-form-item>
          <el-form-item label="skuName">
            <el-input v-model="form.skuName"/>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">Cancel</el-button>
            <el-button type="primary" @click="saveProduct">Confirm</el-button>
          </span>
        </template>
      </el-dialog>
    </div>

  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

import request from "@/utils/request";

export default {
  name: 'HomeView',
  components: 1,
  data() {

    return {
      form: {},
      dialogVisible: false,
      currentPage: 1,
      pageSize: 10,
      totalPage: 0,
      tableData: [],
      keyword: '',
      total: 0
    }
  },

  created() {
    this.load()
  },

  methods: {

    load() {
      console.log("keyword==" + this.keyword)
      request.get("product", {
        params: {
          pageNUm: this.currentPage,
          pageSize: this.pageSize,
          keyword: this.keyword,
        }
      }).then(res => {

        this.tableData = res.data.records

        this.total = res.data.total

        console.log("total==" + this.total)
      })
    },
    addProduct() {
      this.dialogVisible = true
      this.form = {}
    },

    saveProduct() {
      this.dialogVisible = false;
      request.post("product", this.form).then(res => {
        console.log(res)
      })
    },

    handleEdit() {

    },
    handleDelete() {

    },
    handleSizeChange() {

    },
    handleCurrentChange() {

    }
  }


}
</script>
