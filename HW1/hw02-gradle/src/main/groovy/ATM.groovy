class ATM{
    private class banknoteCell{
        int nominal = 0;
        int number = 0;

        banknoteCell(int nominal, int number){
            this.nominal = nominal;
            this.number = number;
        }

        def plus(int amount){
            this.number += (int) amount / nominal
            return this
        }

        def minus(int amount){
            this.number -= (int) amount / nominal
            return this
        }

        int getAmount() {
            return this.number * this.nominal
        }
    }
    List <banknoteCell> balance = []

    ATM(LinkedHashMap money){
        for (el in money.keySet()) {
            this.balance += new banknoteCell(el, money[el])
        }
    }


    def getCell(int nominal){
        for (banknote in this.balance) {
            if (banknote.nominal == nominal) {
                return banknote
            }
        }
        return null
    }

    def receiveMoney(LinkedHashMap money) {
        for (el in money.keySet()){
            banknoteCell cell = getCell(el)
            cell += money[el] * el
        }
    }

    def dispenseMoney(int amount) {
        if (amount > getCurBalance()) {
            println('Error, ATM cant dispence this amount!')
        } else {
            int curAmount = amount
            def cash = new LinkedHashMap()
            for (denomination in this.balance.nominal.sort().reverse()) {
                def number = (int)(curAmount / denomination)
                def curCell = getCell(denomination)
                if (number > curCell.number) {
                    curAmount -= denomination * curCell.number
                    cash[denomination] = curCell.number
                } else {
                    curAmount -= number * denomination
                    cash[denomination] = number
                }
            }
            if (curAmount == 0) {
                for (el in cash.keySet()){
                    def curCell = getCell(el)
                    curCell -= cash[el] * el
                }
                return cash
            }
            else {
                println('Error, ATM cant dispence this amount!')
                return cash
            }
        }
    }

    def getCurBalance(){
        int result = 0
        for (banknote in this.balance){
            result += banknote.getAmount()
        }
        return result
    }

    @Override
    public String toString() {
        return getCurBalance().toString();
    }

}