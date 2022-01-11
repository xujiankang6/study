import Vue from 'vue'
import Router from 'vue-router'
import Login from '../vues/Login'
import Main from '../vues/Main'

Vue.use(Router)

export default new Router({
  routes: [
    {
      // 登陆页
      path: '/login',
      name: 'Login',
      component: Login
    }, {
      // 首页
      path: '/main',
      name: 'Main',
      component: Main
    }
  ]
})
