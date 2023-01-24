// write the BankAccount class here
class  BankAccount constructor(var deposited: Long , var withdrawn: Long  ) {
    var balance: Long=deposited-withdrawn
}