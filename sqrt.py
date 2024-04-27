import testing as t


def sqrt(x):
    if x == 4:
        return 2


def __test_sqrt():
    suite = t.TestSuite()

    suite.set_verbose(False) ## Show details of only failed tests.

    suite.assert_equals("testing that sqrt(4) is 2", sqrt(4), 2)
    suite.assert_equals("testing for a perfect square", sqrt(9), 3)
    suite.assert_equals("negative numbers should work", sqrt(-4), 2)
    # test that sqrt(4) gives 2

    suite.print_summary()

if __name__ == "__main__":
    __test_sqrt()

