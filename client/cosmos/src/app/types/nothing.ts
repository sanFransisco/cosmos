
export abstract class Nothing{
    name:string;
    description:string;
}

export class Black extends Nothing{
   public isBlackHole:boolean;
}

export class White extends Nothing{
    public creator:string;
}

export type NothingImpl = Black | White | Nothing;