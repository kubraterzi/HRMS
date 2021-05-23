package project.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.hrms.business.abstracts.SystemPersonnelService;
import project.hrms.dataAccess.abstracts.SystemPersonnelDao;
import project.hrms.entities.concretes.SystemPersonnel;

import java.util.List;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

    private SystemPersonnelDao systemPersonnelDao;

    @Autowired
    public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
        this.systemPersonnelDao = systemPersonnelDao;
    }

    @Override
    public List<SystemPersonnel> getAll() {
        return systemPersonnelDao.findAll();
    }

    @Override
    public SystemPersonnel get(int id) {
        return systemPersonnelDao.findById(id).get();
    }

    @Override
    public String add(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.save(systemPersonnel);
        return "Added.";
    }

    @Override
    public String delete(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.delete(systemPersonnel);
        return "Deleted.";
    }

    @Override
    public String update(SystemPersonnel systemPersonnel) {
        systemPersonnelDao.save(systemPersonnel);
        return "Updated.";
    }
}
