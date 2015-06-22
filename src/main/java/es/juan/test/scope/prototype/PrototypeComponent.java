package es.juan.test.scope.prototype;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeComponent {
	private int number = ThreadLocalRandom.current().nextInt();

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
