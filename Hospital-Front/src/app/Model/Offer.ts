export class Offer {
  id:number;
  message:string;
  receivedTime: Date;

  constructor(id: number, message: string,receivedTime: Date) {
    this.id = id;
    this.message = message;
    this.receivedTime = receivedTime;
  }
}
