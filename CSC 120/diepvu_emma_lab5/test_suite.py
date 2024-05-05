
class TestSuite:
    def __init__(self):
        '''
        Creates a new test suite, in which one can run test cases (using assert_equals).
        '''
        self.__passes = 0
        self.__fails = 0

    def __pass(self):
        """

        :return: msg 'PASS' and variable increments by 1 if the condition pass is satisfied
        """
        print("PASS")
        self.__passes += 1

    def __fail(self):
        """

        :return: msg 'FAIL' and variable increments by 1 if the condition fail is satisfied
        """
        print("FAIL")
        self.__fails += 1

    def assert_equals(self, msg, expected, actual):
        '''
        Runs a test case, checking whether code being tested produces the correct result 
        for a specific test case. Prints a message indicating whether it does.

        :param: msg is a message to print at the beginning.
        :param: expected is the correct result
        :param: actual is the result of the code under test.
        '''
        print(msg)
        print("expected: " + str(expected))
        print("actual: " + str(actual))

        if expected == actual:
            self.__pass()
        else:
            self.__fail()

        print("")

    def num_tests(self):
        '''
        Returns the number of test cases run so far in the given test suite.
    
        :return: The number of test cases run so far
        '''
        return self.num_passes() + self.num_fails()

    def num_fails(self):
        '''
        Returns the number of failed test cases run so far in the given test suite.
    
        :return: The number of failed test cases run so far
        '''
        return self.__fails

    def num_passes(self):
        '''
        Returns the number of passed test cases run so far in the given test suite.

        :return: The number of passed test cases run so far
        '''
        return self.__passes

    def print_summary(self):
        '''
        Prints a summary of test suite results. Includes a tally of tests run, tests passed,
        and tests failed.
        '''
        print("%d Tests executed, %d Passed, %d Failed" %
              (self.num_tests(), self.num_passes(), self.num_fails()))

