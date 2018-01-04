class User
  attr_accessor :name

  def initialize(name)
    self.name = name
  end

  def balance_with(other, bills)
    balance = 0
    bills.each do |bill|
      if bill.paid_by == other && bill.members.include?(self)
        balance -= bill.share
      elsif bill.paid_by == self && bill.members.include?(other)
        balance += bill.share
      end
    end
    balance
  end

  def balance(bills)
    balance = 0
    bills.each do |bill|
      balance += bill.balance_with self
    end
    balance
  end
end
