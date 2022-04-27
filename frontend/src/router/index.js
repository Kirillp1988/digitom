import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInView from "@/views/LogInView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'logInRouter',
    component: LogInView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
