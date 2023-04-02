export class Supplier {

    constructor(
        public id?: number,
        public name?: string,
        public email?: string,
        public cep?: string,
        public supplierType?: number,
        public cnpj?: number,
        public cpf?: number,
        public rg?: string,
        public birthDate?: string
    ) {}
}