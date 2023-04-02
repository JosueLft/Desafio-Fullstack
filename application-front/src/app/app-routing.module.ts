import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { SupplierRoutes } from "./suppliers";
import { CompanyRoutes } from "./companies";

export const routes: Routes = [
    {
        path: "",
        redirectTo: "/companies/list",
        pathMatch: "full"
    },
    ...CompanyRoutes,
    ...SupplierRoutes
];

@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}