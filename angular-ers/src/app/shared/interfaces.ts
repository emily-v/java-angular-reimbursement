export interface IExpense {
    expId: number;
    submitdate: string;
    transdate: string;
    empid: string;
    expType: string;
    amount: number;
    merchant: string;
    status: string;
    resolveDate: string;
}

export interface IUser {
    empid: string;
    password: string;
    firstName: string;
    lastName: string;
    roles: number[];
}