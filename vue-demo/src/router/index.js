import Vue from 'vue'
import VueRouter from 'vue-router'
import ManageBook from "../views/ManageBook";
import Index from "../views/Index";
import AddBook from "../views/AddBook";
import UpdateBook from "../views/UpdateBook";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '图书管理',
        component: Index,
        redirect: '/manageBook',
        show: true,
        children: [
            {
                path: '/manageBook',
                name: '查询图书',
                component: ManageBook
            },
            {
                path: '/addBook',
                name: '添加图书',
                component: AddBook
            }
        ]
    },
    {
        path: "/updateBook",
        name: "更新图书",
        show: false,
        component: UpdateBook
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
