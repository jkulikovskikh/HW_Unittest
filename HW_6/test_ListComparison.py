import pytest

from ListComparison import ListComparison


@pytest.mark.parametrize("input_list, excepted", [
    ([3, 7, 5], 5),
    ([1], 1),
    ([-1, 5, -10], -2)])
def test_calc_average(input_list, excepted):
    list_comparison = ListComparison(input_list, [1])
    assert list_comparison.calc_average(input_list) == excepted


@pytest.mark.parametrize("input_data", [
    "4",
    5,
    (3, 5)])
def test_type_error(input_data):
    list_comparison = ListComparison(input_data, [1])
    with pytest.raises(TypeError):
        list_comparison.calc_average(input_data)


def test_empty_list():
    list_comparison = ListComparison([], [1])
    with pytest.raises(ZeroDivisionError):
        list_comparison.calc_average([])


@pytest.mark.parametrize("input_1, input_2, excepted", [
    ([1, 13], [5], "Первый список имеет большее среднее значение"),
    ([1, 5, 20], [55], "Второй список имеет большее среднее значение"),
    ([1], [0, 4, -1], "Средние значения равны")])
def test_comparison(input_1, input_2, excepted):
    list_comparison = ListComparison(input_1, input_2)
    assert list_comparison.comparison() == excepted
