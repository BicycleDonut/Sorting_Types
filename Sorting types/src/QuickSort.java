public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};

        sort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    // Быстрая сортировка
    //Разделяй и властвуй (от анг. divide and conquer) — парадигма разработки алгоритмов, заключающаяся в
    //рекурсивном разбиении решаемой задачи на две или более подзадачи того же типа, но меньшего размера, и
    //комбинировании их решений для получения ответа к исходной задаче; разбиения выполняются до тех пор,
    //пока все подзадачи не окажутся элементарными.
    //Пивот (от анг. pivot - поворот) - Элемент, служащий точкой сравнения элементов и их “поворота”, в случае
    //необходимости

    public static void sort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }
        while (leftPosition <= rightPosition);
        if (leftPosition < endPosition) {
            sort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            sort(array, startPosition, rightPosition);
        }
    }
}

