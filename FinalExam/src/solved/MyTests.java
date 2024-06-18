package present;

public class MyTests {
    public static void main(String[] args) {
        Tester t = new Tester();
        t.setVerbose(true);
        testDictionary(t);
        t.finishTests();
    }
    private static void testDictionary(Tester t) {
        Dictionary<String, Integer> numDogs = new DictionaryImpl<String, Integer>();
        numDogs.put("Aaron", 1);
        numDogs.put("Jenn", 2);
        numDogs.put("Nick", 0);

        t.assertEquals("Finding the first entry", Integer.valueOf(1), numDogs.get("Aaron"));
        t.assertEquals("Finding the last entry", Integer.valueOf(0), numDogs.get("Nick"));

        Dictionary<String, String> favouriteSport = new DictionaryImpl<String, String>();

        favouriteSport.put("Aaron", "Cycling");
        favouriteSport.put("Nick", "F1 Racing");
        favouriteSport.put("Aaron", "Hockey");

        t.assertEquals("Getting the reassigned value", "Hockey", favouriteSport.get("Aaron"));
        t.assertEquals("Finding the second entry", "F1 Racing", favouriteSport.get("Nick"));

        // New test case: Getting a value for a key that does not exist
        t.assertEquals("Getting a value for a non-existent key", null, numDogs.get("NonExistentKey"));
    }
}