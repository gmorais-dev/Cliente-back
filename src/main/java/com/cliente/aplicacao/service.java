@Service
 
public class ClienteService {
    @Autowired
     
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente) {
        if (clienteRepository.findByCpfCnpj(cliente.getCpfCnpj()) != null) {
            throw new IllegalArgumentException("Já existe um cliente cadastrado com o CPF/CNPJ informado");
        }
        return clienteRepository.save(cliente);
    }


}



    
    