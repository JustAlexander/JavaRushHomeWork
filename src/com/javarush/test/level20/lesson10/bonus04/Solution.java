package com.javarush.test.level20.lesson10.bonus04;

import java.io.*;
import java.util.*;

/* Свой список
Посмотреть, как реализован LinkedList.
Элементы следуют так: 1->2->3->4  и так 4->3->2->1
По образу и подобию создать Solution.
Элементы должны следовать так:
1->3->7->15
    ->8...
 ->4->9
    ->10
2->5->11
    ->12
 ->6->13
    ->14
Удалили 2 и 9
1->3->7->15
    ->8
 ->4->10
Добавили 16,17,18,19,20 (всегда добавляются на самый последний уровень к тем элементам, которые есть)
1->3->7->15
       ->16
    ->8->17
       ->18
 ->4->10->19
        ->20
Удалили 18 и 20
1->3->7->15
       ->16
    ->8->17
 ->4->10->19
Добавили 21 и 22 (всегда добавляются на самый последний уровень к тем элементам, которые есть.
Последний уровень состоит из 15, 16, 17, 19. 19 последний добавленный элемент, 10 - его родитель.
На данный момент 10 не содержит оба дочерних элемента, поэтому 21 добавился к 10. 22 добавляется в следующий уровень.)
1->3->7->15->22
       ->16
    ->8->17
 ->4->10->19
        ->21

Во внутренней реализации элементы должны добавляться по 2 на каждый уровень
Метод getParent должен возвращать элемент, который на него ссылается.
Например, 3 ссылается на 7 и на 8, т.е.  getParent("8")=="3", а getParent("13")=="6"
Строки могут быть любыми.
При удалении элемента должна удаляться вся ветка. Например, list.remove("5") должен удалить "5", "11", "12"
Итерироваться элементы должны в порядке добавления
Доступ по индексу запрещен, воспользуйтесь при необходимости UnsupportedOperationException
Должно быть наследование AbstractList<String>, List<String>, Cloneable, Serializable
Метод main в тестировании не участвует
*/
public class Solution extends AbstractList<String> implements List<String>, Cloneable, Serializable {
    int size = 0;

    Node<String> root = new Node<>(null, null);
    Node<String> parent = root;

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        List<String> list = new Solution();
        for (int i = 1; i < 16; i++)
        {
            list.add(String.valueOf(i));
        }

        System.out.println("Expected 3, actual is " + ((Solution) list).getParent("8"));
        System.out.println(list.contains("5"));
        System.out.println(list.size());System.out.println("list" + list);
        list.remove("5");
        System.out.println("Один удилил");
        System.out.println(list.size());System.out.println("list" + list);
        System.out.println(list.contains("5"));
        System.out.println("Expected null, actual is " + ((Solution) list).getParent("11"));
        System.out.println(list.size());
        //дополнительная проверка (уже после удаления добавляем ещё пять элементов)
        for (char i = 'a'; i < 'f'; i++)
        {
            list.add(String.valueOf((i)));
        }
        System.out.println("Добивили 5");
        System.out.println(list.size());System.out.println("list" + list);
        System.out.println("Expected 2, actual is " + ((Solution) list).getParent("a"));
        System.out.println("Expected a, actual is " + ((Solution) list).getParent("b"));
        System.out.println("Expected a, actual is " + ((Solution) list).getParent("c"));
        System.out.println("Expected 7, actual is " + ((Solution) list).getParent("d"));
        System.out.println("Expected 8, actual is " + ((Solution) list).getParent("e"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains("a"));
        Object[] s = list.toArray();
        System.out.println(s[4]);
        String[] elements = new String[] { "zzz", "xxx", "ccc" };
        Set set2 = new HashSet(Arrays.asList(elements));
        System.out.println("-------");
        System.out.println(list.containsAll(set2));
        System.out.println(list.size());
        list.addAll(set2);
        System.out.println("Добавили 3");
        System.out.println(list.size());System.out.println("list" + list);
        System.out.println(list.containsAll(set2));
        System.out.println(list.contains("zzz"));
        System.out.println("-------");
        System.out.println(list.size());
        list.removeAll(set2);
        System.out.println("Удалили 3");
        System.out.println(list.size());System.out.println("list" + list);
        System.out.println(list.containsAll(set2));
        System.out.println(list.contains("zzz"));
        System.out.println("----------------------------");
        System.out.println(list.size());
        System.out.println("list" + list.toString());
        List<String> copy = ((Solution) list).clone();
        copy.remove("8");
        System.out.println("copy" + copy.toString());
        list.remove("8");
        System.out.println("list" + list.toString());

        Object[] s1 = copy.toArray();
        System.out.println("Переделать массив!!!!");
        for (Object o : s1)
            System.out.print(o + ", ");
        System.out.println();
        Iterator<String> iterator = copy.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + ", ");
        System.out.println();
        System.out.println(copy.equals(list));

        FileOutputStream fileOutputStream = new FileOutputStream("asd.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(list);

        FileInputStream fileInputStream = new FileInputStream("asd.dat");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        List<String> load = (List<String>) inputStream.readObject();

        System.out.println(list.size());System.out.println(list);

        System.out.println(load.size());System.out.println(load);
        System.out.println(load.isEmpty());
        load.clear();
        System.out.println(load.isEmpty());
    }

    @Override
    public List<String> clone() throws CloneNotSupportedException {
        List<String> sss = new Solution();
        Iterator<String> iterator = new Itr();
        while (iterator.hasNext())
            sss.add(iterator.next());
        return sss;
    }

    public Queue<Node<String>> getSubTree(Node<String> top)
    {
        Queue<Node<String>> queue = new LinkedList<>();
        Queue<Node<String>> subTree = new LinkedList<>();
        if (top != root)
            subTree.add(top);
        do
        {
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
            if (!queue.isEmpty()) top = queue.poll();
            if (!subTree.contains(top))
                subTree.add(top);
        }
        while (!queue.isEmpty() || top.right != null || top.left != null);
        return subTree;
    }

    public String getParent(String value)
    {
        //have to be implemented
        Node<String> searchingNode = findNode(value);
        if (searchingNode == null)
            return null;
        return (searchingNode.parent == null) ? null : searchingNode.parent.value;
    }

    // Поиск нода по значению
    Node<String> findNode(String value)
    {
        Queue<Node<String>> wholeTree = getSubTree(root);
        for (Node<String> node : wholeTree)
        {
            if (node.value == null)
                return null;
            if (node.value.equals(value))
                return node;
        }
        return null;
    }

    private static class Node<String> implements Serializable
    {
        String value;
        Node<String> parent;
        Node<String> left;
        Node<String> right;

        private Node(String value, Node<String> parent)
        {
            this.value = value;
            this.parent = parent;
        }
        private static final long serialVersionUID = 876323223445176354L;
        private void writeObject(java.io.ObjectOutputStream s)
                throws java.io.IOException {
            s.defaultWriteObject();
            s.writeObject(value);
            s.writeObject(parent);
            s.writeObject(left);
            s.writeObject(right);
        }

        @SuppressWarnings("unchecked")
        private void readObject(java.io.ObjectInputStream s)
                throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            value = (String) s.readObject();
            parent = (Node<String>) s.readObject();
            left = (Node<String>) s.readObject();
            right = (Node<String>) s.readObject();
        }
    }

    @Override
    public String get(int index)
    {
        throw new UnsupportedOperationException();
    }

    protected Solution() {
        super();
    }

    //++
    @Override
    public int size()
    {
        return size;
    }

    //++
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    //++
    @Override
    public boolean contains(Object value) {
        return findNode((String) value) != null;
    }

    //++
    @Override
    public Object[] toArray() {
        ArrayList<Object> sss = new ArrayList<>();
        Iterator<String> iter = new Itr();
        while (iter.hasNext())
            sss.add(iter.next());
        return sss.toArray();
    }

    //++
    @Override
    public boolean remove(Object value)
    {
        Queue<Node<String>> queueForRemove = getSubTree(findNode((String) value));

        parent = findNode((String) value).parent;
        for (Node<String> node : queueForRemove)
        {
            if (node.parent.left != node && node.parent.right != node && node.left != null && node.parent.left != null) {
                if (node.parent.left.equals(node)) {
                    node.parent.left = null;
                   // size--;
                }
                else if (node.parent.right.equals(node)) {
                    node.parent.right = null;
                  //  size--;
                }
            }
            else if (node.parent != null) {
                if (parent.right == node) {
                    node.parent.right = null;
                   // size--;
                }
                else if (parent.left == node) {
                    node.parent.left = null;
                   // size--;
                }
            }
            node = null;
            size--;
        }
        return true;
    }

    //++
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    //++
    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean result = true;
        for (Object o : c) {
            if (!add(o.toString()))
                result = false;
        }
        return result;
    }

    //++
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for (Object o : c) {
            if (!remove(o))
                result = false;
        }
        return result;
    }

    //+
    @Override
    public void clear() {
        Node top = root;
        Queue<Node<String>> queue = new LinkedList<> ();
        queue.add(top);
        do{
            if (!queue.isEmpty()) top=queue.poll();
            else break;
            if (top.left!=null) queue.add(top.left);
            if (top.right!=null) queue.add(top.right);
            top.value = null;
            top.left = null;
            top.right = null;
            top.parent = null;
            top=null;
        }while (!queue.isEmpty());
        size = 0;
    }

    //++
    @Override
    public String toString() {
        Iterator<String> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            String e = it.next();
            sb.append(e.equals(this) ? "(this Collection)" : e);

            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    //++
    @Override
    public boolean add(String value)
    {
        Node<String> newNode = new Node<>(value, parent);

        // если левый слот родительского нода пуст
        if (parent.left == null)
        {
            newNode.parent = parent;
            parent.left = newNode;
            size++;
        }
        // если правый слот родительского нода пуст
        else if (parent.right == null)
        {
            newNode.parent = parent;
            parent.right = newNode;
            size++;
        }
        // если оба слота родительского нода заняты
        else
        {
            // ищем следующий свободный слот
            Queue<Node<String>> wholeTree = getSubTree(root);
            for (Node<String> node : wholeTree)
            {
                if (node.left == null || node.right == null)
                {
                    parent = node;
                    break;
                }
            }
            add(value);
        }

        return true;
    }

    //++
    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    //+
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        List<String> list1 = (Solution) o;
        Iterator<String> itr1 = list1.iterator();
        Iterator<String> itr2 = new Itr();
        while (itr1.hasNext() || itr2.hasNext()) {
            if (itr1.next().equals(itr2.next()))
                result = true;
            else return false;
        }
        return result;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    //+
    @Override
    public ListIterator<String> listIterator() {
        return super.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public class Itr implements Iterator<String>  {
        Node top = root;

        Queue<Node> queue_fin = new LinkedList<> ();

        int expectedModCount = modCount;


        public Itr()
        {
            Queue<Node> queue = new LinkedList<> ();

            do{
                if (top.left!=null)
                {
                    queue.add(top.left);
                    if (!queue_fin.contains(top.left))
                        queue_fin.add(top.left);
                }
                if (top.right!=null)
                {
                    queue.add(top.right);
                    if (!queue_fin.contains(top.right))
                        queue_fin.add(top.right);
                }
                if (!queue.isEmpty()) top=queue.poll();
            }while (!queue.isEmpty() || top.right != null || top.left != null);
        }

        public boolean hasNext() {

            return !queue_fin.isEmpty();

        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("All nodes have been visited!");
            }
            checkForComodification();
            try {
                top = queue_fin.poll();
                String next = top.value.toString();
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private static final long serialVersionUID = 876432162645176354L;

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(size);
        s.writeObject(root);
        s.writeObject(parent);
        Iterator<String> iterator = new Itr();
        while (iterator.hasNext())
            s.writeObject(iterator.next());
    }

    @SuppressWarnings("unchecked")
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden serialization magic
        s.defaultReadObject();
        size = s.readInt();
        root = (Node<String>) s.readObject();
        parent = (Node<String>) s.readObject();
        while (s.available()>0)
            add((String) s.readObject());
    }
}