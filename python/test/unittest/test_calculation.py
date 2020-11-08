import unittest

import calculation


class CalTest(unittest.TestCase):
    def setUp(self):
        self.cal = calculation.Calculation()

    def tearDown(self):
        del self.cal

    def test_add(self):
        self.assertEqual(self.cal.add(1, 1), 2)

    def test_add_raise(self):
        with self.assertRaises(ValueError):
            self.cal.add('1', '1')

    def test_multiply(self):
        self.assertEqual(self.cal.multiply(2, 2), 4)

    @unittest.skip('Specifications undecided')
    def test_multiply_raise(self):
        with self.assertRaises(ValueError):
            self.cal.add('1', '1')


if __name__ == '__main__':
    unittest.main()
