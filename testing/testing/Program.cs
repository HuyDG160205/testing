class Testing {
    static void Main() {


    }

    static void algorithm() {
        List<int> list = new List<int>([3, 0, 1]);
        int count = 0;

        foreach (int i in list) {
            if (list.Contains(count)) {
                count++;
                continue;
            }
            break;
        }
        Console.WriteLine(count);

    }
}