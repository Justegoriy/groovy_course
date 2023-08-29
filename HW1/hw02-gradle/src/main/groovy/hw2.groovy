static void main(String[] args) {
    def atm = new ATM([50 : 3, 100 : 3, 500 : 3, 1000 : 4, 5000: 3])
    assert atm.getCurBalance() == 20950
    atm.receiveMoney([50 : 1, 100 : 3])
    assert atm.getCurBalance() == 21300
    assert [5000:1, 1000:1, 500:1, 100:1, 50:1]  == atm.dispenseMoney(6650)
    assert atm.getCurBalance() == 14650
    assert null  == atm.dispenseMoney(100000)
}