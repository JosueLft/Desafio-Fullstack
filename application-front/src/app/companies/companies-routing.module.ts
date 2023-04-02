import { Routes } from "@angular/router";
import { ListCompaniesComponent } from "./components/list/list-companies.component";
import { RegisterCompanyComponent } from "./components/register/register-company.component";
import { ListCompanySuppliersComponent } from "./components/list-company-suppliers";
import { RegisterCompanySuppliersComponent } from "./components/register-company-suppliers";

export const CompanyRoutes: Routes = [
    {
        path: "companies",
        redirectTo: "companies/list"
    },
    {
        path: "companies/list",
        component: ListCompaniesComponent
    },
    {
        path: "companies/register",
        component: RegisterCompanyComponent
    },
    {
        path: "companies/:id/suppliers",
        component: ListCompanySuppliersComponent
    },
    {
        path: "companies/:id/register-supplier",
        component: RegisterCompanySuppliersComponent
    }
]