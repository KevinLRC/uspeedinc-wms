<template>
  <div class="home" style="padding: 10px">
    <div style="margin: 10px 0;">
      <el-button type="primary">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="关键字" style="width: 20%"/>
      <el-button type="primary" style="margin-left: 5px">搜索</el-button>
    </div>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="date" label="Date" sortable/>
      <el-table-column prop="name" label="Name"/>
      <el-table-column prop="address" label="Address"/>

      <el-table-column label="操作" >
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
      <el-pagination background layout="prev, pager, next"
                     :current-page="currentPage"
                     :page-size="10"
                     :page-sizes="[5, 10, 20]"
                     :total="totalPage"
                     @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"

      />
    </div>

  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: 1,
  data() {

    return {
      currentPage: 1,
      totalPage: 100,
      tableData,
      search: ''
    }
  },
  methods: {
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

const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]
</script>
