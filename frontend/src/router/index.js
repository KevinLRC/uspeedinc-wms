import {createRouter, createWebHistory} from 'vue-router'
import MainLayout from '../layout/MainLayout'
import LoginView from '../views/LoginView'

const routes = [
    {
        path: '/',
        name: 'MainLayout',
        component: MainLayout,
        redirect:"/home",
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
        path: '/login',
        name: 'Login',
        component: LoginView

    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
