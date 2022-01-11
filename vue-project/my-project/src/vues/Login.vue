<template>
  <div>
    <el-form ref='form' :model="form" :rules="rules" class="login-box">
      <h3 class="login-title">欢迎登陆</h3>
      <el-form-item label="账号" prop="name">
        <el-input type="text" v-model="form.name" placeholder="请输入用户名"></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
      </el-form-item>

      <el-button type="primary" @click="subForm('form')">登录</el-button>

    </el-form>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        form: {
          name: "",
          password: ""
        },
        rules: {
          name: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      subForm(formname) {
        this.$refs[formname].validate((valid) => {
          if (valid) {
            this.$router.push("/main");
          } else {
            this.$message({
              message: '请输入用户名或密码！',
              type: 'warning'
            });
            return false;
          }
        });

      }
    }
  }
</script>
<style>

  .login-box {
    width: 350px;
    margin: 150px auto;
    border: 1px solid #DCDFE6;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 0 30px #DCDFE6;

  }

  .login-title {
    text-align: center;

  }

</style>
