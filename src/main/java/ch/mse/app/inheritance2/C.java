package ch.mse.app.inheritance2;

// public class C extens A, B {
// 	@Override
// 	public void foo() {
// 		System.out.println("C::foo");
// 		super.foo();
// 	}
//
// 	@Override
// 	public void bar() {
// 		System.out.println("C::bar");
// 		test();
// 	}
//
// 	@Override
// 	public void test() {
// 		System.out.println("C::test");
// 		super.test();
// 	}
// }

public class C extends B implements IA {
	final _A _super;

	C() {
		_super = new _A(this);
	}

	@Override
	public void foo() {
		System.out.println("C::foo");
		_super._foo();
	}

	@Override
	public void bar() {
		System.out.println("C::bar");
		test();
	}
	
	@Override
	public void test() {
		System.out.println("C::test");
		super.test();
	}

}
