package manager.component;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.Vector;

public class ManagerFocusPolicy extends FocusTraversalPolicy {

	Vector<Component> order;
	public ManagerFocusPolicy(Vector<Component> order) {
		this.order = new Vector<Component>(order.size());
        this.order.addAll(order);		
	}
	
	@Override
	public Component getComponentAfter(Container aContainer, Component aComponent) {
		int idx = (order.indexOf(aComponent) + 1) % order.size();
		return order.get(idx);
	}

	@Override
	public Component getComponentBefore(Container aContainer, Component aComponent) {
		int idx = order.indexOf(aComponent) - 1;
        if (idx < 0) {
            idx = order.size() - 1;
        }
        return order.get(idx);
	}

	@Override
	public Component getFirstComponent(Container aContainer) {
		return order.get(0);
	}

	@Override
	public Component getLastComponent(Container aContainer) {
		return order.lastElement();
	}

	@Override
	public Component getDefaultComponent(Container aContainer) {
		return order.get(0);
	}

}
