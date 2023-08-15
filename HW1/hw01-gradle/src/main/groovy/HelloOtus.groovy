import com.google.common.collect.Lists

class Main {
    static void main(String[] args) {
        println "Hello otus!"
        List<Character> chars = Lists.charactersOf("Hello otus!")
        println(chars.size())
        println(chars)
    }
}