<template>
  <div style="width: 100%; height: 100vh; background-color: cornflowerblue; overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
      <div style="color: #cccccc; font-size: 30px; text-align: center">Login</div>
      <div style="padding: 20px">
        <el-form :model="form">
          <el-form-item>
            <el-input prefix-icon="el-icon-user-solid" v-model="form.username"/>
          </el-form-item>
          <el-form-item>
            <el-input prefix-icon="el-icon-lock" v-model="form.password" show-password/>
          </el-form-item>
          <el-form-item>
            <el-button style="width: 100%" type="primary" @click="login">登陆</el-button>
          </el-form-item>
        </el-form>
      </div>

    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "LoginView",
  data() {
    return {
      form: {}
    }
  },
  methods: {
    login() {
      request.post("user/login", this.form).then(res => {
        if (res.code === '0') {
          this.$message(
              {
                type: "success",
                message: "登陆成功"
              }
          )
          this.$router.push("/")
        } else {
          this.$message(
              {
                type: "error",
                message: res.msg
              }
          )
        }
      })
    }
  }
}
</script>

<style scoped>

</style>