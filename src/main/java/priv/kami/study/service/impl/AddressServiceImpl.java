package priv.kami.study.service.impl;

import priv.kami.study.po.Address;
import priv.kami.study.mapper.AddressMapper;
import priv.kami.study.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kami
 * @since 2024-03-14
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
