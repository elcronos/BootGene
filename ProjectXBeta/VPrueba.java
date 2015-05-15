
import Expression client_rpc_fqn is undefined on line 5, column 10 in Templates/Vaadin/Component.java.;
import Expression server_rpc_fqn is undefined on line 6, column 10 in Templates/Vaadin/Component.java.;
import Expression shared_state_fqn is undefined on line 7, column 10 in Templates/Vaadin/Component.java.;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;

public class VPrueba extends AbstractComponent {
    
    private Expression server_rpc is undefined on line 17, column 15 in Templates
    /Vaadin
    /Component.java.rpc  = new Expression 
    server_rpc is undefined on line 17, column 39 in Templates
    /Vaadin

    /Component.java. () {
    private int clickCount = 0;
    
    public void clicked(MouseEventDetails mouseDetails) {
        // nag every 5:th click using RPC
        if (++clickCount % 5 == 0) {
            getRpcProxy(Expression client_rpc is undefined on line 23, column 31 in Templates/Vaadin / Component.java
            ..class  
            
            ).alert(
                        "Ok, that's enough!");
            }
            // update shared state
            getState().text = "You have clicked " + clickCount + " times";
        }
    }

    ;

    public VPrueba() {
        registerRpc(rpc);
    }
    
    @Override
    public Expression shared_state is undefined on line 36, column 14 in Templates
    /Vaadin

    /Component.java.getState () {
        return (Expression shared_state  is undefined on line 37, column 19 in Templates/Vaadin / Component.java.
        ) super.getState();
    }
}
