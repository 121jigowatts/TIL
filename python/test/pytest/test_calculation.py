"""
# 実行
pytest .\test_calculation.py
"""
import pytest

import calculation


class TestCal(object):
    @classmethod
    def setup_class(cls):
        print('start')
        cls.cal = calculation.Calculation()

    @classmethod
    def teardown_class(cls):
        print('end')
        del cls.cal

    def setup_method(self, method):
        print(f'method={method.__name__}')
        # self.cal = calculation.Calculation()

    def teardown_method(self, method):
        print(f'method={method.__name__}')
        # del self.cal

    def test_add(self):
        assert self.cal.add(1, 1) == 2

    def test_add_raise(self):
        with pytest.raises(ValueError):
            self.cal.add('1', '1')

    def test_multiply(self):
        assert self.cal.multiply(2, 2) == 4

    @pytest.mark.skip(reasen='Specifications undecided')
    def test_multiply_raise(self):
        with pytest.raises(ValueError):
            self.cal.add('1', '1')
