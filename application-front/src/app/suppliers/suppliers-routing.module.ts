import { Routes } from "@angular/router";
import { ListSuppliersComponent } from "./components/list";
import { RegisterSupplierComponent } from "./components/register";

export const SupplierRoutes: Routes = [
    {
        path: "suppliers",
        redirectTo: "suppliers/list"
    },
    {
        path: "suppliers/list",
        component: ListSuppliersComponent
    },
    {
        path: "suppliers/register",
        component: RegisterSupplierComponent
    }
];