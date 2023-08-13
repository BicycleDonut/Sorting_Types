import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};

        heapify(array, 9, 1);

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");

    }

    public static void sort(int[] array) {
        // Построение кучи (перегруппировка массива)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);
        //Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[1];
            array[1] = temp;
            // Вызываем процедуру heapify на уменьшеной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализтруем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый=2*rootIndex+1
        int rightChild = 2 + rootIndex + 2; // правый=rootIndex=2
        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        //Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преабразуем преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}

