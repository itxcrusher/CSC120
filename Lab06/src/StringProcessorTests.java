public class StringProcessorTests
{
    public static void main (String [] args)
    {
        Tester t = new Tester(true);

        testInsertAfter(t);
        testRemoveAll(t);
        testRemoveOnce(t);
        testReplaceOnce(t);
        testReplaceLast(t);
        testPrepend(t);
        testAppend(t);

        t.finishTests();
    }

    public static void testInsertAfter(Tester t)
    {
        StringProcessor sp = new StringProcessor();

        t.assertEquals("inserting after the first character",
                       "alf",
                       sp.insertAfter("af", 'a', 'l'));

        t.assertEquals("inserting a string after the first character",
                       "aloof",
                       sp.insertAfter("af", 'a', "loo"));

        t.assertEquals("inserting in a string with more occurrences",
                       "alpha",
                       sp.insertAfter("apha", 'a', 'l'));					   
    }

    public static void testRemoveAll(Tester t) {
        StringProcessor sp = new StringProcessor();
        t.assertEquals("Removing all 'l' from 'hello'",
                "heo",
                sp.removeAll("hello", 'l'));
        t.assertEquals("Removing a character not in string",
                "hello",
                sp.removeAll("hello", 'x'));
        t.assertEquals("Removing all 'h' from 'hhhh'",
                "",
                sp.removeAll("hhhh", 'h'));
    }

    public static void testRemoveOnce(Tester t) {
        StringProcessor sp = new StringProcessor();
        t.assertEquals("Removing the first occurrence of 'l' in 'hello'",
                "helo",
                sp.removeOnce("hello", 'l', 1));
        t.assertEquals("Removing the third occurrence of 'l' in 'hello'",
                "hello",
                sp.removeOnce("hello", 'l', 3));  // No third occurrence
    }

    public static void testReplaceOnce(Tester t) {
        StringProcessor sp = new StringProcessor();
        t.assertEquals("Replacing the first 'l' in 'hello' with 'x'",
                "hexlo",
                sp.replaceOnce("hello", 'l', 'x'));
        t.assertEquals("Trying to replace non-existent character",
                "hello",
                sp.replaceOnce("hello", 'z', 'x'));
    }

    public static void testReplaceLast(Tester t) {
        StringProcessor sp = new StringProcessor();
        t.assertEquals("Replacing the last 'l' in 'hello' with 'x'",
                "helxo",
                sp.replaceLast("hello", 'l', 'x'));
        t.assertEquals("Replacing the only 'h' in 'hello' with 'y'",
                "yello",
                sp.replaceLast("hello", 'h', 'y'));
    }

    public static void testPrepend(Tester t) {
        StringProcessor sp = new StringProcessor();
        t.assertEquals("Prepending 'a' to 'apple'",
                "aapple",
                sp.prepend("apple", 'a'));
        t.assertEquals("Prepending 'start ' to 'finish'",
                "start finish",
                sp.prepend("finish", "start "));
    }

    public static void testAppend(Tester t) {
        StringProcessor sp = new StringProcessor();
        t.assertEquals("Appending 's' to 'apple'",
                "apples",
                sp.append("apple", 's'));
        t.assertEquals("Appending ' end' to 'start'",
                "start end",
                sp.append("start", " end"));
    }

}
