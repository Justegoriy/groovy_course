import com.google.common.collect.Lists



class Main {
    class RomanNumber{
        String roman;
        int arabian;

        String toRoman(arabian){
            def roman = ''
            switch(arabian) {
                case 1 : roman = 'I'; break;
                case 2 : roman = 'II'; break;
                case 3 : roman = 'III'; break;
                case 4 : roman = 'IV'; break;
                case 5 : roman = 'V'; break;
                case 6 : roman = 'VI'; break;
                case 7 : roman = 'VII'; break;
                case 8 : roman = 'VIII'; break;
                case 9 : roman = 'IX'; break;
                default: 'Big number'; break;
            }
            return roman;
        }

        RomanNumber(int arabian) {
            this.arabian = arabian;
            this.roman = toRoman(arabian);
        }

        def plus(RomanNumber other){
            return new RomanNumber(this.arabian + other.arabian)
        }

        @Override
        public String toString(){
            return this.roman
        }

    }
    static void main(String[] args) {
        def rom1 = new RomanNumber(3);
        def rom2 = new RomanNumber(2);
        println(rom1 + rom2)
    }
}