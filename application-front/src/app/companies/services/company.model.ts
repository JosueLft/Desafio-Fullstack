import { Supplier } from "src/app/suppliers";

export class Company {

    constructor(
        public id?: number,
        public tradingName?: string,
        public cnpj?: number,
        public cep?: string,
        public suppliers: Supplier[] = []
    ) {}
}