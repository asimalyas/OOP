/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Member;

public class MemberRepository extends AbstractRepository<Member> {
    @Override
    public Member findById(int memberId) {
        for (Member member : items) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
}
