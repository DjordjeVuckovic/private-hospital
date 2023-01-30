import {BloodUnit} from "./BloodUnit";

export class BloodContract{
  public bloodUnits?: BloodUnit[];
  public price: number = 0;
  public deliveryDate?:Date;
  public hospitalName:string = "Best Hospital"
}
