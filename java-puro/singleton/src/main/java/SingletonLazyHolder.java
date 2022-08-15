public class SingletonLazyHolder {

    private static class IntanceHolder {
        public static SingletonLazyHolder intancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {}

    public static SingletonLazyHolder getInstance() {
        return IntanceHolder.intancia;
    }
}
