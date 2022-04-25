import {createRouter, createWebHistory} from 'vue-router'
import MainLayout from '../layout/MainLayout'
import LoginView from '../views/LoginView'
import ContainerListView from '../views/container/ContainerListView'

const routes = [
    {
        path: '/dashboard',
        name: 'MainLayout',
        component: MainLayout,

        children: [
            {
                path: '/sw-product-details',
                name: 'SWProductDetails',
                component: () => import("@/views/SWProductDetailsView"),
            },
            {
                path: '/sw-stock',
                name: 'SWStock',
                component: () => import("@/views/SWStockView"),
            }
        ]
    },
    {
        path: '/',
        name: 'Root',
        redirect:"/dashboard",
    },
    {
        path: '/login',
        name: 'Login',
        component: LoginView

    },
    {
        path: '/containerlist',
        name: 'ContainerList',
        component: ContainerListView

    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
